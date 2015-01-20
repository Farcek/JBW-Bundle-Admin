/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.le.farcek.jbw.bundle.admin;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Farcek
 */
@Singleton
public class JBWAdminMenuManager implements Iterable<JBWAdminMenuManager.Item> {

    public JBWAdminMenuManager() {
        System.out.println("JBWAdminMenuManager creates");
    }

    private final Item root = new Item();

    public JBWAdminMenuManager add(String name, String url) {
        String[] paths = name.split("/");

        Item c = root;
        for (String p : paths) {
            c = c.getOrCreate(p);
        }

        c.url = url;

        return this;
    }

    @Override
    public Iterator<Item> iterator() {
        return root.values().iterator();
    }

    class Item extends HashMap<String, Item> {

        private String path;
        private String name;
        private String url;

        private Item getOrCreate(String p) {
            Item get = get(p);
            if (get == null) {
                get = new Item();
                get.path = path == null ? p : path + "/" + p;
                get.name = name == null ? p : name + "." + p;
                put(p, get);
            }
            return get;
        }

        public String getUrl() {
            return url;
        }

        public String getPath() {
            return path;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Item{" + "path=" + path + ", name=" + name + ", url=" + url + '}';
        }

    }
}
