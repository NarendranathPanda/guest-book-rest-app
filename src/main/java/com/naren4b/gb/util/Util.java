package com.naren4b.gb.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class Util {

	public static boolean isPhoneNumberValid(String phoneStr) {
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		PhoneNumber thePhoneNumber = null;
		try {
			thePhoneNumber = phoneUtil.parse(phoneStr, "IN");
		} catch (NumberParseException e) {
			System.err.println("Cannot parse the given phone number string " + phoneStr);
			e.printStackTrace();
		}
		return phoneUtil.isValidNumber(thePhoneNumber);
	}

}
