package com.sbt.jscool;

import java.util.*;

public class Main {

    public interface CountMap<T> {
        // добавляет элемент в этот контейнер.
        void add(T o);

        //Возвращает количество добавлений данного элемента
        int getCount(T o);

        //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
        int remove(T o);

        //количество разных элементов
        int size();

        //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
        void addAll(CountMap source);

        //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
        Map toMap();

        //Тот же самый контракт как и toMap(), только всю информацию записать в destination
        void toMap(Map destination);
    }

    public static class CountMapIml<T> implements CountMap<T> {

        private Map<T, Integer> data;

        public CountMapIml() {
            data = new HashMap<>();
        }

        @Override
        public void add(T o) {
            if (data.containsKey(o)) {
                data.put(o, data.get(o) + 1);
            } else {
                data.put(o, 1);
            }

        }

        @Override
        public int getCount(T o) {
            if (data.containsKey(o)) {
                return data.get(o);
            } else {
                return 0;
            }
        }

        @Override
        public int remove(T o) {
            if (data.containsKey(o)) {
                int result = data.get(o);
                data.remove(o);
                return result;
            } else {
                return 0;
            }
        }

        @Override
        public int size() {
            return data.size();
        }

        @Override
        public void addAll(CountMap source) {

        }

        @Override
        public Map toMap() {
            return data;
        }

        @Override
        public void toMap(Map destination) {
            destination = data;
        }
    }

    public static class CollectionUtils {
        public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
            destination.addAll(source);
        }

        public static <T> List <? super T> newArrayList() {
            return new ArrayList<T>();
        }

        public static <T> int indexOf(List <? extends T> source, T o) {
            return source.indexOf(o);
        }

        public static <T> List limit(List<? extends T> source, int size) {
            if (source.size() < size) {
                return source;
            }
            else {
                return source.subList(0, size);
            }
        }

        public static <T> void add(List<? super T> source, T o) {
            source.add(o);
        }

        public static <T> void removeAll(List<? extends T> removeFrom, List c2) {
            removeFrom.removeAll(c2);
        }

        public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
            return c1.containsAll(c2);
        }

        public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
            for (T elem: c2
                 ) {
                if (c1.contains(elem)) {
                    return true;
                }
            }
            return false;
        }

       /* public static <T> List range(List<? extends T> list, Object min, Object max) {
            List<? super T> result = new ArrayList<>();
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i).compareTo(min) >= 0 && list.get(i).compareTo(min) <= 0) {
                    result.add(list.get(i));
                }
            }
            return result;
        }*/

        public static <T> List range(List<? extends T> list, Object min, Object max, Comparator comparator) {
            List<? super T> result = new ArrayList<>();
            for (int i = 0; i < list.size(); ++i) {
                if (comparator.compare(list.get(i), min) >= 0 && comparator.compare(list.get(i), min) <= 0) {
                    result.add(list.get(i));
                }
            }
            return result;
        }

    }


    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println(map.getCount(10));
        System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
        System.out.println(map.getCount(11));

    }
}
