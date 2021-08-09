package me.silentdoer;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * 用命令：mvn io.quarkus:quarkus-maven-plugin:1.13.7.Final:create创建后手动创建这个类文件
 * test目录删除
 * mvn clean package
 * QuarkusMain注解会使得Quarkus框架对XxxApplication做一些代理处理
 * @author wlq
 * @version 1.0.0
 * @since 2021/8/9 15:22
 */
@QuarkusMain
public class XxxApplication implements QuarkusApplication {

	public static void main(String[] args) {
		System.out.println("Running main method33");
		//Quarkus.run(XxxApplication.class, args);
		Quarkus.run(args);
		System.out.println("started ?" + Thread.currentThread().getName());
	}

	@Override
	public int run(String... args) {
		if (true) {
			throw new RuntimeException("aaa");
		}
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		// 和main不在一个线程里执行的
		System.out.println("###" + Thread.currentThread().getName());
		Quarkus.waitForExit();
		System.out.println("##2#" + Thread.currentThread().getName());
		return 0;
	}
}
