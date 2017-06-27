package com.ctrip.xpipe.redis.core.protocal.cmd;

import java.util.concurrent.ScheduledExecutorService;

import com.ctrip.xpipe.api.pool.SimpleObjectPool;
import com.ctrip.xpipe.netty.commands.NettyClient;

/**
 * @author wenchao.meng
 *
 * Dec 2, 2016
 */
public abstract class AbstractConfigCommand<T> extends AbstractRedisCommand<T>{
	
	public static String CONFIG = "config";

	public AbstractConfigCommand(SimpleObjectPool<NettyClient> clientPool, ScheduledExecutorService scheduled) {
		super(clientPool, scheduled);
	}
	
	public static enum REDIS_CONFIG_TYPE{
		
		MIN_SLAVES_TO_WRITE("min-slaves-to-write"),
		REWRITE("rewrite"),
		DISKLESS_SYNC("repl-diskless-sync"),
		DISKLESS_SYNC_DELAY("repl-diskless-sync-delay"),
		SLAVE_READONLY("slave-read-only"),

		SLAVE_REPL_ALL("slave-repl-all")//extend for xredis
		;
		
		private String configName;
		
		REDIS_CONFIG_TYPE(String configName){
			this.configName = configName;
		}
		
		public String getConfigName() {
			return configName;
		}
		
	}

}