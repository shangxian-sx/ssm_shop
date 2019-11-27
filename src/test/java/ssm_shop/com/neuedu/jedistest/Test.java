package ssm_shop.com.neuedu.jedistest;

public class Test {
	public static void main(String[] args) {
		final String name;
		 name = "张三";
		 System.out.println(name);
//		 name = "lisi";
		 System.out.println("=========================");
		 final User user = new User();
		 user.age = 2;
		 System.out.println(user.age);
		 user.age = 3;
		 System.out.println(user.age);
	}
}
