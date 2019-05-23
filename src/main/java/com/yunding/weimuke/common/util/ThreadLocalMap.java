package com.yunding.weimuke.common.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalMap {
    /**
     * 本地线程变量
     */
    private final static ThreadLocal<Map<String, Object>> THREAD_CONTEXT = new MapThreadLocal();

    /**
     * 添加对象
     *
     * @param key   键
     * @param value 值
     */
    public static void put(String key, Object value) {
        getContextMap().put(key, value);
    }

    /**
     * 删除对象
     *
     * @param key the key
     *
     * @return the object
     */
    public static Object remove(String key) {
        return getContextMap().remove(key);
    }

    /**
     * Get object.
     *
     * @param key the key
     *
     * @return the object
     */
    public static Object get(String key) {
        return getContextMap().get(key);
    }

    private static class MapThreadLocal extends ThreadLocal<Map<String, Object>> {
        /**
         * 初始化
         *
         * @return the map
         */
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>(8) {

                private static final long serialVersionUID = 5393730067932464601L;

                @Override
                public Object put(String key, Object value) {
                    return super.put(key, value);
                }
            };
        }
    }

    /**
     * 取得thread context Map的实例。
     *
     * @return thread context Map的实例
     */
    private static Map<String, Object> getContextMap() {
        return THREAD_CONTEXT.get();
    }

    /**
     * 清理线程所有被hold住的对象。以便重用！
     */
    public static void remove() {
        getContextMap().clear();
    }

}
