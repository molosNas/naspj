package com.molos.util;

import java.sql.Timestamp;
import java.util.Date;

import com.molos.tools.common.DateUtil;

public class TimeUtil extends DateUtil {

	/**
	 * @param d
	 * @return
	 */
	public static Timestamp dateToTimestamp(Date d) {
		return new Timestamp(d.getTime());
	}

	/**
	 * @param t
	 * @return
	 */
	public static Date timestampToDate(Timestamp t) {
		return new Date(t.getTime());
	}
}
