package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SlkUtil {
	public static Object deepClone(Object object) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(object);
			
			// 反序列化
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream  ois = new ObjectInputStream(bis);
			object = ois.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}
		return object;
	}
}
