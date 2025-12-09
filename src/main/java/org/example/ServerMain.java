package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.http2.server.HTTP2ServerConnectionFactory;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import org.eclipse.jetty.alpn.server.ALPNServerConnectionFactory;

public class ServerMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerMain.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("started program");

        Server server = new Server();

        HttpConfiguration httpConfig = new HttpConfiguration();
        httpConfig.addCustomizer(new SecureRequestCustomizer());

        HttpConnectionFactory http11 = new HttpConnectionFactory(httpConfig);

        HTTP2ServerConnectionFactory http2 = new HTTP2ServerConnectionFactory(httpConfig);
        http2.setMaxConcurrentStreams(128);
        http2.setConnectProtocolEnabled(true);

        ALPNServerConnectionFactory alpn = new ALPNServerConnectionFactory();
        alpn.setDefaultProtocol(http11.getProtocol());

        SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
        sslContextFactory.setKeyStorePath("keystore");
        sslContextFactory.setKeyStorePassword("secret");
        
        SslConnectionFactory tls = new SslConnectionFactory(sslContextFactory, alpn.getProtocol());

        ServerConnector connector = new ServerConnector(server, tls, alpn, http2, http11);
        connector.setPort(9009);
        connector.setHost("0.0.0.0");
        connector.setIdleTimeout(30_000);
        server.addConnector(connector);

        server.setHandler(new HelloWorldHandler());

        server.start();
        server.join();
    }

}
