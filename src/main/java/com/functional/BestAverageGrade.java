package com.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class BestAverageGrade {

	public static void main(String[] args) {
		String studentsData[][] = { { "Sarah", "0" }, { "Goldie", "92" }, { "Elaine", "93" }, { "Elaine", "95" },
				{ "Goldie", "94" }, { "Sarah", "-9999" } };
		String studentData2[][] = { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } };

		System.out.println(findBestAvgSum(studentData2));

	}

	private static int findBestAvgSum(String[][] sData) {

		if (sData.length == 0 || sData == null) {
			return 0;
		}

		HashMap<String, List<Integer>> sDataMap = new HashMap<>();

		for (int i = 0; i < sData.length; i++) {

			List<Integer> data = sDataMap.get(sData[i][0]);

			if (data == null) {
				List<Integer> curData = new ArrayList<>();
				curData.add(Integer.parseInt(sData[i][1]));
				sDataMap.put(sData[i][0], curData);
			} else {
				data.add(Integer.parseInt(sData[i][1]));
				sDataMap.put(sData[i][0], data);
			}

		}

		System.out.println(sDataMap);
		int highAvg = 0;
		for (Entry<String, List<Integer>> k : sDataMap.entrySet()) {
			int currAvg = getAverage(k.getValue());
			String studentName = k.getKey();

			highAvg = Math.max(highAvg, currAvg);

			System.out.println(studentName + " --> " + highAvg);
		}

		return highAvg;
	}

	private static int getAverage(List<Integer> l) {
		int sum = 0;
		for (int a : l) {
			sum += a;
		}

		return sum / l.size();
	}
}
