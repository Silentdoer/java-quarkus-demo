package me.silentdoer;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * 用命令：mvn io.quarkus:quarkus-maven-plugin:1.13.7.Final:create创建后手动创建这个类文件
 * test目录删除
 * mvn clean package
 * @author wlq
 * @version 1.0.0
 * @since 2021/8/9 15:22
 */
@QuarkusMain
public class Application {

	public static void main(String[] args) {
		System.out.println("Running main method33");
		Quarkus.run(args);
		System.out.println("started ?");
	}

	public static class MyApp implements QuarkusApplication {

		@Override
		public int run(String... args) {
			System.out.println("Do startup logic here[after start, before receive req]");
			Quarkus.waitForExit();
			System.out.println("shutdowned ?");
			new Thread(() -> {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}).start();
			return 0;
		}
	}
}
