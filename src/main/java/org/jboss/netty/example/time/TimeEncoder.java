package org.jboss.netty.example.time;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class TimeEncoder extends SimpleChannelHandler {

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		UnixTime m = (UnixTime) e.getMessage();
		ChannelBuffer buf = ChannelBuffers.buffer(4);
		
		buf.writeInt(m.getValue());
		Channels.write(ctx, e.getFuture(), buf);
		Channels.fireChannelDisconnected(ctx);
	}

}
