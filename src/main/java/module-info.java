/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module Doorbell {
    requires org.slf4j;
    
    requires java.net.http;
    
    requires org.eclipse.jetty.server;
    requires jakarta.servlet;
    requires org.eclipse.jetty.http2.server;
    requires org.eclipse.jetty.alpn.server;
}
