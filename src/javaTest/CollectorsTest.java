package javaTest;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static class User implements Serializable {
        public String name;
        public Integer age;
        public String tel;

        public Integer getAge() {
            return age;
        }

        public User(String name, Integer age, String tel) {
            this.name = name;
            this.age = age;
            this.tel = tel;
        }
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User("name" + i, i, "11-11" + 1);
            list.add(user);
        }

        User x = new User("",Integer.MIN_VALUE,"");

//        Optional<User> max = list.stream().filter(i -> i.age < 20).max(
//                (t,y) -> {
//                    if (x.age > y.age) {
//                        return x.age;
//                    } else {
//                        return y.age;
//                    }
//                }
//        );
        // 找到UserList内某个属性的最大值
        Optional<Integer> max = list.stream().map(i -> i.age).max(Integer::compareTo);

        // 最大值对应的对象
        Comparator<User> comparator = Comparator.comparing(User::getAge);
        Optional<User> max1 = list.stream().max(comparator);

        List<Integer> collect = list.stream().map(i -> i.age).collect(Collectors.toList());
        Map<Integer, String> collect1 = list.stream().collect(Collectors.toMap(i -> i.getAge(), i -> i.name));

        System.out.println();
    }
}
