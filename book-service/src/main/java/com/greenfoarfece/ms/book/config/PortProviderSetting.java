package com.greenfoarfece.ms.book.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

@Component
public class PortProviderSetting implements EmbeddedServletContainerCustomizer {
	
	@Value("#{'${server.portRange:${server.port:0}}'.split('-')}")
	private List<Integer> portRange;

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(getAvailablePort().intValue());
	}
	
	private Integer getAvailablePort() {
		Integer port = null;
		if(portRange.size() == 1){
			port = portRange.get(0);
		} else {
			port = SocketUtils.findAvailableTcpPort(portRange.get(0), portRange.get(1));
		}
		return port;
	}

}
