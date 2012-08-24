package shadow.mods.metallurgy;

import java.io.*;
import java.util.*;

public final class MetallurgyProps {

    public MetallurgyProps(String s) {
        field_26618_lines = new ArrayList();
        field_26619_props = new HashMap();
        field_26620_fileName = s;
        File file = new File(field_26620_fileName);
        if(file.exists()) {
            try {
                func_26600_load();
            }
            catch(IOException ioexception) {
                System.out.println((new StringBuilder()).append("[Props] Unable to load ").append(field_26620_fileName).append("!").toString());
            }
        } else {
            func_26596_save();
        }
    }

    public void func_26600_load()
        throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(field_26620_fileName), "UTF8"));
        field_26618_lines.clear();
        field_26619_props.clear();
        String s;
        while((s = bufferedreader.readLine()) != null)  {
            s = new String(s.getBytes(), "UTF-8");
            char c = '\0';
            int i;
            for(i = 0; i < s.length() && Character.isWhitespace(c = s.charAt(i)); i++) { }
            if(s.length() - i == 0 || s.charAt(i) == '#' || s.charAt(i) == '!') {
                field_26618_lines.add(s);
            } else {
                int j = i;
                boolean flag = s.indexOf('\\', i) != -1;
                StringBuffer stringbuffer = flag ? new StringBuffer() : null;
                if(stringbuffer != null) {
                    do {
                        if(i >= s.length() || Character.isWhitespace(c = s.charAt(i++)) || c == '=' || c == ':') {
                            break;
                        }
                        if(flag && c == '\\') {
                            if(i == s.length()) {
                                s = bufferedreader.readLine();
                                if(s == null) {
                                    s = "";
                                }
                                i = 0;
                                while(++i < s.length() && Character.isWhitespace(c = s.charAt(i))) ;
                            } else {
                                c = s.charAt(i++);
                            }
                        } else {
                            switch(c) {
                            case 110: 
                                stringbuffer.append('\n');
                                break;

                            case 116: 
                                stringbuffer.append('\t');
                                break;

                            case 114: 
                                stringbuffer.append('\r');
                                break;

                            case 117: 
                                if(i + 4 <= s.length()) {
                                    char c1 = (char)Integer.parseInt(s.substring(i, i + 4), 16);
                                    stringbuffer.append(c1);
                                    i += 4;
                                }
                                break;

                            case 111: 
                            case 112: 
                            case 113: 
                            case 115: 
                            default:
                                stringbuffer.append('\0');
                                break;
                            }
                        }
                    } while(true);
                }
                boolean flag1 = c == ':' || c == '=';
                String s1;
                if(flag) {
                    s1 = stringbuffer.toString();
                } else
                if(flag1 || Character.isWhitespace(c)) {
                    s1 = s.substring(j, i - 1);
                } else {
                    s1 = s.substring(j, i);
                }
                for(; i < s.length() && Character.isWhitespace(c = s.charAt(i)); i++) { }
                if(!flag1 && (c == ':' || c == '=')) {
                    char c2;
                    for(i++; i < s.length() && Character.isWhitespace(c2 = s.charAt(i)); i++) { }
                }
                if(!flag) {
                    field_26618_lines.add(s);
                } else {
                    StringBuilder stringbuilder = new StringBuilder(s.length() - i);
                    do {
                        if(i >= s.length()) {
                            break;
                        }
                        char c3 = s.charAt(i++);
                        if(c3 == '\\') {
                            if(i == s.length()) {
                                s = bufferedreader.readLine();
                                if(s == null) {
                                    break;
                                }
                                char c4;
                                for(i = 0; i < s.length() && Character.isWhitespace(c4 = s.charAt(i)); i++) { }
                                stringbuilder.ensureCapacity((s.length() - i) + stringbuilder.length());
                                continue;
                            }
                            char c5 = s.charAt(i++);
                            switch(c5) {
                            case 110: 
                                stringbuilder.append('\n');
                                break;

                            case 116: 
                                stringbuilder.append('\t');
                                break;

                            case 114: 
                                stringbuilder.append('\r');
                                break;

                            case 117: 
                                if(i + 4 <= s.length()) {
                                    char c6 = (char)Integer.parseInt(s.substring(i, i + 4), 16);
                                    stringbuilder.append(c6);
                                    i += 4;
                                    break;
                                }
                                continue;

                            case 111: 
                            case 112: 
                            case 113: 
                            case 115: 
                            default:
                                stringbuilder.append('\0');
                                break;
                            }
                        }
                        stringbuilder.append('\0');
                    } while(true);
                    field_26618_lines.add((new StringBuilder()).append(s1).append("=").append(stringbuilder.toString()).toString());
                }
            }
        }
        bufferedreader.close();
    }

    public void func_26596_save() {
        FileOutputStream fileoutputstream = null;
        try {
            fileoutputstream = new FileOutputStream(field_26620_fileName);
        }
        catch(FileNotFoundException filenotfoundexception) {
            System.out.println((new StringBuilder()).append("[Props] Unable to open ").append(field_26620_fileName).append("!").toString());
        }
        PrintStream printstream = null;
        try {
            printstream = new PrintStream(fileoutputstream, true, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            System.out.println((new StringBuilder()).append("[Props] Unable to write to ").append(field_26620_fileName).append("!").toString());
        }
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = field_26618_lines.iterator(); iterator.hasNext();) {
            String s = (String)iterator.next();
            if(s.trim().length() == 0) {
                printstream.println(s);
            } else
            if(s.charAt(0) == '#') {
                printstream.println(s);
            } else
            if(s.contains("=")) {
                int i = s.indexOf('=');
                String s1 = s.substring(0, i).trim();
                if(field_26619_props.containsKey(s1)) {
                    String s2 = (String)field_26619_props.get(s1);
                    printstream.println((new StringBuilder()).append(s1).append("=").append(s2).toString());
                    arraylist.add(s1);
                } else {
                    printstream.println(s);
                }
            } else {
                printstream.println(s);
            }
        }

        Iterator iterator1 = field_26619_props.entrySet().iterator();
        do {
            if(!iterator1.hasNext()) {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            if(!arraylist.contains(entry.getKey())) {
                printstream.println((new StringBuilder()).append((String)entry.getKey()).append("=").append((String)entry.getValue()).toString());
            }
        } while(true);
        printstream.close();
        try {
            field_26619_props.clear();
            field_26618_lines.clear();
            func_26600_load();
        }
        catch(IOException ioexception) {
            System.out.println((new StringBuilder()).append("[Props] Unable to load ").append(field_26620_fileName).append("!").toString());
        }
    }

    public Map func_26604_returnMap()
        throws Exception {
        HashMap hashmap = new HashMap();
        BufferedReader bufferedreader = new BufferedReader(new FileReader(field_26620_fileName));
        do {
            String s;
            if((s = bufferedreader.readLine()) == null) {
                break;
            }
            if(s.trim().length() != 0 && s.charAt(0) != '#' && s.contains("=")) {
                int i = s.indexOf('=');
                String s1 = s.substring(0, i).trim();
                String s2 = s.substring(i + 1).trim();
                hashmap.put(s1, s2);
            }
        } while(true);
        bufferedreader.close();
        return hashmap;
    }

    public boolean func_26610_containsKey(String s) {
        for(Iterator iterator = field_26618_lines.iterator(); iterator.hasNext();) {
            String s1 = (String)iterator.next();
            if(s1.trim().length() != 0 && s1.charAt(0) != '#' && s1.contains("=")) {
                int i = s1.indexOf('=');
                String s2 = s1.substring(0, i);
                if(s2.equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    public String func_26615_getProperty(String s) {
        for(Iterator iterator = field_26618_lines.iterator(); iterator.hasNext();) {
            String s1 = (String)iterator.next();
            if(s1.trim().length() != 0 && s1.charAt(0) != '#' && s1.contains("=")) {
                int i = s1.indexOf('=');
                String s2 = s1.substring(0, i).trim();
                String s3 = s1.substring(i + 1);
                if(s2.equals(s)) {
                    return s3;
                }
            }
        }

        return "";
    }

    public void func_26606_removeKey(String s) {
        Boolean boolean1 = Boolean.valueOf(false);
        if(field_26619_props.containsKey(s)) {
            field_26619_props.remove(s);
            boolean1 = Boolean.valueOf(true);
        }
        try {
            for(int i = 0; i < field_26618_lines.size(); i++) {
                String s1 = (String)field_26618_lines.get(i);
                if(s1.trim().length() != 0 && s1.charAt(0) != '#' && s1.contains("=")) {
                    int j = s1.indexOf('=');
                    String s2 = s1.substring(0, j).trim();
                    if(s2.equals(s)) {
                        field_26618_lines.remove(i);
                        boolean1 = Boolean.valueOf(true);
                    }
                }
            }

        }
        catch(ConcurrentModificationException concurrentmodificationexception) {
            func_26606_removeKey(s);
            return;
        }
        if(boolean1.booleanValue()) {
            func_26596_save();
        }
    }

    public boolean func_26611_keyExists(String s) {
        try {
            return func_26610_containsKey(s);
        }
        catch(Exception exception) {
            return false;
        }
    }

    public String func_26614_getString(String s) {
        if(func_26610_containsKey(s)) {
            return func_26615_getProperty(s);
        } else {
            return "";
        }
    }

    public String func_26599_getString(String s, String s1) {
        if(func_26610_containsKey(s)) {
            return func_26615_getProperty(s);
        } else {
            func_26616_setString(s, s1);
            return s1;
        }
    }

    public void func_26616_setString(String s, String s1) {
        field_26619_props.put(s, s1);
        func_26596_save();
    }

    public int readInt(String s) {
        if(func_26610_containsKey(s)) {
            return Integer.parseInt(func_26615_getProperty(s));
        } else {
            return 0;
        }
    }

    public int setInt(String s, int i) {
        if(func_26610_containsKey(s)) {
            return Integer.parseInt(func_26615_getProperty(s));
        } else {
            func_26603_setInt(s, i);
            return i;
        }
    }

    public void func_26603_setInt(String s, int i) {
        field_26619_props.put(s, String.valueOf(i));
        func_26596_save();
    }

    public double func_26605_getDouble(String s) {
        if(func_26610_containsKey(s)) {
            return Double.parseDouble(func_26615_getProperty(s));
        } else {
            return 0.0D;
        }
    }

    public double func_26607_getDouble(String s, double d) {
        if(func_26610_containsKey(s)) {
            return Double.parseDouble(func_26615_getProperty(s));
        } else {
            func_26609_setDouble(s, d);
            return d;
        }
    }

    public void func_26609_setDouble(String s, double d) {
        field_26619_props.put(s, String.valueOf(d));
        func_26596_save();
    }

    public long func_26598_getLong(String s) {
        if(func_26610_containsKey(s)) {
            return Long.parseLong(func_26615_getProperty(s));
        } else {
            return 0L;
        }
    }

    public long func_26613_getLong(String s, long l) {
        if(func_26610_containsKey(s)) {
            return Long.parseLong(func_26615_getProperty(s));
        } else {
            func_26617_setLong(s, l);
            return l;
        }
    }

    public void func_26617_setLong(String s, long l) {
        field_26619_props.put(s, String.valueOf(l));
        func_26596_save();
    }

    public boolean func_26612_getBoolean(String s) {
        if(func_26610_containsKey(s)) {
            return Boolean.parseBoolean(func_26615_getProperty(s));
        } else {
            return false;
        }
    }

    public boolean func_26597_getBoolean(String s, boolean flag) {
        if(func_26610_containsKey(s)) {
            return Boolean.parseBoolean(func_26615_getProperty(s));
        } else {
            func_26601_setBoolean(s, flag);
            return flag;
        }
    }

    public void func_26601_setBoolean(String s, boolean flag) {
        field_26619_props.put(s, String.valueOf(flag));
        func_26596_save();
    }

    private String field_26620_fileName;
    private List field_26618_lines;
    private Map field_26619_props;
}
