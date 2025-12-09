/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jetty.http2.api.Session;
import org.eclipse.jetty.http2.api.Stream;
import org.eclipse.jetty.http2.api.server.ServerSessionListener;
import org.eclipse.jetty.http2.frames.HeadersFrame;
import org.eclipse.jetty.http2.frames.PingFrame;
import org.eclipse.jetty.http2.frames.ResetFrame;
import org.eclipse.jetty.http2.frames.SettingsFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author edwbuck
 */
public class SessionListener implements ServerSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void onAccept(Session session) {
        SocketAddress remoteAddress = session.getRemoteSocketAddress();
        LOGGER.info("Connection from {}", remoteAddress);
    }

    @Override
    public Map<Integer, Integer> onPreface(Session session) {
        Map<Integer, Integer> settings = new HashMap<>();

        // Tell the client that HTTP/2 push is disabled.
        settings.put(SettingsFrame.ENABLE_PUSH, 0);

        return settings;
    }

    @Override
    public Stream.Listener onNewStream(Stream stream, HeadersFrame headersFrame) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onSettings(Session sn, SettingsFrame sf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onPing(Session sn, PingFrame pf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onReset(Session sn, ResetFrame rf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean onIdleTimeout(Session sn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
