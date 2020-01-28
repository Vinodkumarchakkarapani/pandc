package com.PandC.tests;

import com.periscope.qif.json.TestCaseStep;

import java.util.Comparator;

public class srNOSort implements Comparator<TestCaseStep>
{
	@Override
	public int compare(TestCaseStep o1, TestCaseStep o2) {
		return o1.srNo > o2.srNo?-1:0;
	}
}
