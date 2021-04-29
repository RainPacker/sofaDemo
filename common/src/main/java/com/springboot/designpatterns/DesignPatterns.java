package com.springboot.designpatterns;

import com.springboot.designpatterns.builder.Computer;
import com.springboot.designpatterns.builder.ConcreteBuilder;
import com.springboot.designpatterns.builder.Director;
import com.springboot.designpatterns.decorate.Circle;
import com.springboot.designpatterns.decorate.Rectangle;
import com.springboot.designpatterns.decorate.RedShapeDecorator;
import com.springboot.designpatterns.decorate.Shape;
import com.springboot.designpatterns.proxy.IService;
import com.springboot.designpatterns.proxy.ProxyService;
import com.springboot.designpatterns.proxy.Service;
import com.springboot.designpatterns.proxy.ServiceInvocationHandler;
import com.springboot.designpatterns.strategy.ConcreteStrategyA;
import com.springboot.designpatterns.strategy.ConcreteStrategyB;
import com.springboot.designpatterns.strategy.Context;

import java.lang.reflect.Proxy;

/**
 * File Name: DesignPatterns
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 09:49
 * 设计模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class DesignPatterns {

    public static void main(String[] args) {
        //  Singleton singletonA=new Singleton();
        SingletonB singletonB2 = SingletonB.getInstance();
        SingletonB singletonB3 = SingletonB.getInstance();
        singletonB2.print();
        System.out.println(singletonB2 == singletonB3);
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);

        //普通工厂模式  建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
        Sender sender = produce("mail");
        sender.send();
        Sender senderSms = produce("sms");
        senderSms.send();
        //多个工厂方法模式
        SendFactory sendFactory = new SendFactory();
        Sender sender1 = sendFactory.produceMail();
        sender1.send();
        //静态工厂方法模式   将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
        Sender sender2 = StaticSendFactory.produceSms();
        sender2.send();
        //抽象工厂方法模式
        /*
         * 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要扩展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？
         * 那么这就用到了抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
         */
        Provider provider = new MailSendFactory();
        Sender sender3 = provider.produce();
        sender3.send();
        // 建造者模式  工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director();
        director.construct(concreteBuilder);
        Computer computer = concreteBuilder.getComputer();
        computer.print();
        //适配器模式
        // 适配器模式是将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的的类的兼容性问题。主要分三类：类的适配器模式、对象的适配器模式、接口的适配器模式。

        //策略模式
        //策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类），提供辅助函数。策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，对各种算法做封装。因此，策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可。
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
        //代理模式
        //静态代理
        //静态代理需要我们写出代理类和被代理类，而且一个代理类和一个被代理类一一对应。代理类和被代理类需要实现同一个接口，通过聚合使得代理对象中有被代理对象的引用，以此实现代理对象控制被代理对象的目的。
        IService service = new Service();
        ProxyService proxyService = new ProxyService(service);
        proxyService.service();
        //动态代理
        /*
         * JDK 1.3 之后，Java通过java.lang
         * .reflect包中的三个类Proxy、InvocationHandler、Method来支持动态代理。动态代理常用于有若干个被代理的对象，且为每个被代理对象添加的功能是相同的（例如在每个方法运行前后记录日志）。
         *
         * 动态代理的代理类不需要我们编写，由Java自动产生代理类源代码并进行编译最后生成代理对象。
         * 创建动态代理对象的步骤：
         * 1. 指明一系列的接口来创建一个代理对象
         * 2. 创建一个调用处理器（InvocationHandler）对象
         * 3. 将这个代理指定为某个其他对象的代理对象
         * 4. 在调用处理器的invoke（）方法中采取代理，一方面将调用传递给真实对象，另一方面执行各种需要的操作
         */
        IService service1 = new Service();
        Class<? extends IService> service1Class = service1.getClass();
        IService proxy = (IService) Proxy.newProxyInstance(service1Class.getClassLoader(), service1Class.getInterfaces(),
                new ServiceInvocationHandler(service1));
        System.out.println(proxy);
        proxy.service();
        //装饰模式 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例。
        //使用自定义来装饰 shape 对象
        Circle circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("\nCircle of red border");
        redCircle.draw();
        System.out.println("\nRectangle of red border");
        redRectangle.draw();

    }

    public static Sender produce(String str) {
        if ("mail".equals(str)) {
            return new MailSender();
        } else if ("sms".equals(str)) {
            return new SmsSender();
        } else {
            System.out.println("输入错误...");
            return null;
        }
    }

}
