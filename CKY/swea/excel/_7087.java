package CKY.swea.excel;

import java.util.*;
import java.io.*;

public class _7087 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			int size = Integer.parseInt(br.readLine());

			List<String> list = new ArrayList<>();

			boolean[] b = new boolean[26];

			while (size-- > 0) {
				String title = br.readLine();
				b[title.substring(0, 1).charAt(0) - 'A'] = true;
				list.add(title);
			}

			int titleCount = 0;
			for (int j = 0; j < b.length; j++) {
				if (!b[j])
					break;
				titleCount++;
			}

			System.out.println("#" + i + " " + titleCount);

		}
	}
}
