package org.openwis.dataservice.useralarms;

import java.util.List;

import javax.jws.WebParam;

import org.openwis.dataservice.common.domain.entity.useralarm.UserAlarm;
import org.openwis.dataservice.common.domain.entity.useralarm.UserAlarmReferenceType;

/**
 * Local interface to the UserAlarmManager.
 */
public interface UserAlarmManagerLocal {

	/**
	 * Raises a user alarm.  This will persist the user alarm.
	 */
	public void raiseUserAlarm(UserAlarm alarm);

	/**
	 * Return a list containing all the user alarms for a particular user with a reference to a particular reference
	 * type.
	 *
	 * @param username The user's username.  Cannot be <code>null</code>
	 * @param referenceType The reference type.  Cannot be <code>null</code>.
	 * @param offset The offset
	 * @param limit The limit
	 * @return A list of user alarms.
	 */
   public List<UserAlarm> getUserAlarmsForUserAndReferenceType(String username, UserAlarmReferenceType referenceType, int offset, int limit);

   /**
    * Acknowledges a user alarm.  This will remove the user alarm from the database.  If the user alarm could not be found, no operation
    * will be performed.
    *
    * @param alarmId
    *       The id of the user alarm to acknowledge.
    */
   public void acknowledgeUserAlarm(long alarmId);

   /**
    * Like {@link #acknowledgeUserAlarm(long)}, but takes a username along with a list of alarm Ids.  The alarms must be owned by
    * the particular user in order to be removed.  All other alarms are not removed.
    *
    * @param username   The username
    * @param alarmIds   The list of alarm ids
    * @return           The total number of alarms acknowledged.
    */
   public int acknowledgeAlarmsForUser(String username, List<Long> alarmIds);

   /**
    * Acknowledges all alarms for a particular user.
    *
    * @param username   The username
    */
   public void acknowledgeAllAlarmsForUser(String username);
}