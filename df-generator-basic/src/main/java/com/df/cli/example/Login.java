package com.df.cli.example;

import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(subcommands={ASCIIArt.class},name = "Login", version = "Login 1.0", mixinStandardHelpOptions = true)
public class Login implements Callable<Integer> {
    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    // 设置了 arity 参数，可选交互式
    @CommandLine.Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", prompt ="请输入密码：", interactive = true)
    String password;

    // 设置了 arity 参数，可选交互式
    @CommandLine.Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", prompt ="请确认密码：",interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123","--help");
    }
}
