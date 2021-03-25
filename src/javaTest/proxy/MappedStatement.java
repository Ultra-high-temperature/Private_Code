package javaTest.proxy;

public class MappedStatement implements UserDao{
    @Override
    public Object selectUserById(Integer id) {
        System.out.printf("实际干活的");
        return null;
    }
}
