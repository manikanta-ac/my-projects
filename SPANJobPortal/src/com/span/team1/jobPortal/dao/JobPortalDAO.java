package com.span.team1.jobPortal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.span.team1.jobPortal.model.Feed;
import com.span.team1.jobPortal.model.Job;
import com.span.team1.jobPortal.model.UserInfo;

public class JobPortalDAO
{
	private static String driverName;
	private static Connection connection;
	private static ResultSet resultSet;
	private static PreparedStatement preparedStatement;
	private static String url;
	private static String userName;
	private static String password;

	static
	{
		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3309/job_portal";
		userName = "root";
		password = "acmk";
	}

	private static void openConnection()
	{
		try
		{
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	private static void closeConnection()
	{
		try
		{
			if(connection!=null)	
				connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private static void closePreparedStatement()
	{
		try
		{
			if(preparedStatement!=null)
				preparedStatement.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	private static void closeResultSet()
	{
		try
		{
			if(resultSet!=null)
				resultSet.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static String getUserName(String email) 
	{	
		openConnection();

		String userName = "";
		try
		{
			preparedStatement = connection.prepareStatement("select FirstName from personaldetail where Email=?");

			preparedStatement.setString(1, email);

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
				userName = resultSet.getString(1);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}

		return userName;
	}

	public static int getUserId(String userName)
	{
		openConnection();

		int userId = -1;
		try
		{
			preparedStatement = connection.prepareStatement("select Id from personaldetail where FirstName=?");

			preparedStatement.setString(1, userName);

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
				userId= resultSet.getInt(1);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}

		return userId;
	}

	public static void personalDetail(String fname, String email, String password)
	{
		openConnection();

		try
		{
			preparedStatement = connection.prepareStatement("insert into personaldetail (FirstName, Email, Password) values(?,?,?);");

			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);

			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closePreparedStatement();
			closeConnection();
		}
	}

	public static void academicDetail(String userName, String qualification, String collegeName, String stream, String percentage, String yearOfPassing)
	{		
		int userId = getUserId(userName);

		openConnection();

		try
		{
			preparedStatement = connection.prepareStatement("insert into academicdetail values(?,?,?,?,?,?);");

			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, qualification);
			preparedStatement.setString(3, collegeName);
			preparedStatement.setString(4, stream);
			preparedStatement.setString(5, percentage);
			preparedStatement.setString(6, yearOfPassing);

			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closePreparedStatement();
			closeConnection();
		}
	}
	public static boolean login(String emailid,String password)
	{
		openConnection();

		boolean flag=false;
		try
		{
			preparedStatement = connection.prepareStatement("select Email,Password from personaldetail");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{

				if(emailid.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2)))
				{
					return flag=true;
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return flag;
	}
	
	public static List<Job> getJobs(int userId)
	{
		List<Integer> jobIds = new ArrayList<Integer>();
		List<Job> jobs = new ArrayList<Job>();

		Job job;

		openConnection();

		try
		{
			preparedStatement = connection.prepareStatement("select jobId from applied_jobs where userId=?");

			preparedStatement.setInt(1, userId);

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				jobIds.add(resultSet.getInt(1));
			}

			closeResultSet();
			closePreparedStatement();

			for(int jobId:jobIds)
			{
				preparedStatement = connection.prepareStatement("select * from job where jobId=?");
				preparedStatement.setInt(1, jobId);
				resultSet = preparedStatement.executeQuery();

				resultSet.next();

				job = new Job();

				job.setJobId(jobId);
				job.setPostedDate(resultSet.getDate(2).toString());
				job.setCompanyName(resultSet.getString(3));
				job.setCompanyURL(resultSet.getString(4));
				job.setCompanyProfile(resultSet.getString(5));
				job.setIndustry(resultSet.getString(6));
				job.setSalary(resultSet.getDouble(7));
				job.setSkills(resultSet.getString(8));
				job.setJobLcation(resultSet.getString(9));
				job.setVenueLocation(resultSet.getString(10));
				job.setPosition(resultSet.getString(11));
				job.setExperience(resultSet.getString(12));
				job.setQualifications(resultSet.getString(13));
				job.setLastDate(resultSet.getDate(14).toString());

				jobs.add(job);

				closeResultSet();
				closePreparedStatement();
			}			

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return jobs;
	}

	public static Job getJob(int jobId)
	{		
		Job job = null;

		openConnection();

		try
		{			
			preparedStatement = connection.prepareStatement("select * from job where jobId=?");
			preparedStatement.setInt(1, jobId);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();

			job = new Job();

			job.setJobId(jobId);
			job.setPostedDate(resultSet.getDate(2).toString());
			job.setCompanyName(resultSet.getString(3));
			job.setCompanyURL(resultSet.getString(4));
			job.setCompanyProfile(resultSet.getString(5));
			job.setIndustry(resultSet.getString(6));
			job.setSalary(resultSet.getDouble(7));

			if(resultSet.getString(8)==null)
				job.setSkills("---");
			else
				job.setSkills(resultSet.getString(8));

			job.setJobLcation(resultSet.getString(9));
			job.setVenueLocation(resultSet.getString(10));
			job.setPosition(resultSet.getString(11));
			job.setExperience(resultSet.getString(12));
			job.setQualifications(resultSet.getString(13));
			job.setLastDate(resultSet.getDate(14).toString());	

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return job;
	}

	public static void applyJob(int userId, int jobId)
	{
		openConnection();

		try
		{
			preparedStatement = connection.prepareStatement("insert into applied_jobs values(?,?);");

			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, jobId);

			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closePreparedStatement();
			closeConnection();
		}
	}
	public static List<Feed> getAllComments()
	{
		List<Feed> comments = new ArrayList<Feed>();

		Feed feed;

		openConnection();

		try
		{
			preparedStatement = connection.prepareStatement("select * from feedback LIMIT 10;");

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				feed = new Feed();

				feed.setName(resultSet.getString(1));
				feed.setComments(resultSet.getString(2));

				comments.add(feed);

			}			

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return comments;
	}
	public static void feedback(String uname, String comments)
	{
		openConnection();

		try
		{
			preparedStatement = connection.prepareStatement("insert into feedback values(?,?)");

			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, comments);

			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closePreparedStatement();
			closeConnection();
		}
	}

	public static UserInfo getUserInfo(int id) {

		UserInfo userInfo = null;
		openConnection();
		try {
			preparedStatement = connection
					.prepareStatement("select * from academicdetail where Id="
							+ id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			userInfo = new UserInfo();
			userInfo.setId(id);
			userInfo.setQualification(resultSet.getString(2));
			userInfo.setCollegeName(resultSet.getString(3));
			userInfo.setStream(resultSet.getString(4));
			userInfo.setPercentage(""+resultSet.getInt(5));
			userInfo.setYearOfPassing(""+resultSet.getInt(6));

			closeResultSet();
			closePreparedStatement();
			preparedStatement = connection
					.prepareStatement("select * from personaldetail where Id="
							+ id);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			userInfo.setFirstName(resultSet.getString(2));
			userInfo.setEmail(resultSet.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return userInfo;

	}

	public static List<Job> getRecommendedJobs(int userId) {

		List<Job> jobs = new ArrayList<Job>();

		Job job;

		openConnection();

		try {
			preparedStatement = connection
					.prepareStatement("select Highest_Qualification from academicdetail where id="
							+ userId);

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next())
			{
				String highestQualification = resultSet.getString(1);

				StringTokenizer st = new StringTokenizer(highestQualification, "/");

				String[] jobSeekerQualification = new String[st.countTokens()];

				int count = 0,count1,count2;

				while (st.hasMoreTokens()) {
					jobSeekerQualification[count] = st.nextToken();
					count++;
				}
				closeResultSet();
				closePreparedStatement();

				preparedStatement = connection
						.prepareStatement("select qualifications,jobId from job");

				resultSet = preparedStatement.executeQuery();

				String[] jobQualification = null;
				ResultSet resultSet1=null;
				PreparedStatement preparestatement1=null;

				while (resultSet.next()) 
				{
					String Qualification = resultSet.getString(1);
					int id=resultSet.getInt(2);
					StringTokenizer st1 = new StringTokenizer(Qualification,",");

					jobQualification = new String[st1.countTokens()];
					count = 0;
					while (st1.hasMoreTokens()) {
						jobQualification[count] = st1.nextToken();
						count++;
					}

					L1:for(count1=0;count1<jobSeekerQualification.length;count1++)
					{
						for(count2=0;count2<jobQualification.length;count2++)
						{
							if(jobSeekerQualification[count1].equalsIgnoreCase(jobQualification[count2]))
							{							
								preparestatement1=connection.prepareStatement("select * from job where jobId="+id);   
								resultSet1=preparestatement1.executeQuery();
								resultSet1.next();

								job = new Job();

								job.setJobId(id);
								job.setPostedDate(resultSet1.getDate(2).toString());
								job.setCompanyName(resultSet1.getString(3));
								job.setCompanyURL(resultSet1.getString(4));
								job.setCompanyProfile(resultSet1.getString(5));
								job.setIndustry(resultSet1.getString(6));
								job.setSalary(resultSet1.getDouble(7));
								job.setSkills(resultSet1.getString(8));
								job.setJobLcation(resultSet1.getString(9));
								job.setVenueLocation(resultSet1.getString(10));
								job.setPosition(resultSet1.getString(11));
								job.setExperience(resultSet1.getString(12));
								job.setQualifications(resultSet1.getString(13));
								job.setLastDate(resultSet1.getDate(14).toString());

								jobs.add(job);

								try {
									if (resultSet1 != null)
										resultSet1.close();
									if (preparestatement1 != null)
										preparestatement1.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
								break L1;
							}
						}
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return jobs;
	}
	public static void updateUserDetails(UserInfo user,String userName) 
	{		
		String firstName = user.getFirstName();
		String email = user.getEmail();
		String pass = user.getPassword();
		String qualification = user.getQualification();
		String collegeName = user.getCollegeName();
		String stream = user.getStream();
		String percentage = user.getPercentage();
		String yearOfPassing = user.getYearOfPassing();
		
		int userId = getUserId(userName);
		
		openConnection();
		
		try
		{
			preparedStatement = connection.prepareStatement("update personaldetail set FirstName=?, Email=?, Password=? where Id=?;");

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, pass);
			preparedStatement.setInt(4, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closePreparedStatement();
		}
		
		try
		{
			preparedStatement = connection.prepareStatement("update academicdetail set Highest_Qualification=?," +
					"College_Name=?,Specialisation=?,Percentage=?,Year_Of_Passing=? where Id=?;");

			preparedStatement.setString(1, qualification);
			preparedStatement.setString(2, collegeName);
			preparedStatement.setString(3, stream);
			preparedStatement.setString(4, percentage);
			preparedStatement.setString(5, yearOfPassing);
			preparedStatement.setInt(6, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closePreparedStatement();
			closeConnection();
		}
	}
	public static List<Job> searchjob(String i1,String k1,String e1,String q1,String sa1,String l1)
	{		
		List<Job> jobs = new ArrayList<Job>();
		Job job = null;
		openConnection();

		StringBuilder sqlQuery = new StringBuilder("select * from job where 1 = 1 ");
		try
		{			
			if(!i1.equals("none"))
			{
				sqlQuery.append(" and industry='"+i1+"' ");
			}
			if(!k1.equals(""))
			{
				sqlQuery.append(" and skills='"+k1+"'");
			}
			if(!e1.equals("none"))
			{
				sqlQuery.append(" and experience='"+e1+"'");
			}
			if(!q1.equals("none"))
			{
				sqlQuery.append(" and qualifications='"+q1+"'");
			}
			if(!sa1.equals("none"))
			{
				sqlQuery.append(" and salary='"+sa1+"'");
			}
			if(!l1.equals(""))
			{
				sqlQuery.append(" and jobLcation='"+l1+"'");
			}
			preparedStatement = connection.prepareStatement(sqlQuery.toString());
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				job = new Job();
				
				job.setJobId(resultSet.getInt(1));
				job.setPostedDate(resultSet.getDate(2).toString());
				job.setCompanyName(resultSet.getString(3));
				job.setCompanyURL(resultSet.getString(4));
				job.setCompanyProfile(resultSet.getString(5));
				job.setIndustry(resultSet.getString(6));
				job.setSalary(resultSet.getDouble(7));
				job.setSkills(resultSet.getString(8));
				job.setJobLcation(resultSet.getString(9));
				job.setVenueLocation(resultSet.getString(10));
				job.setPosition(resultSet.getString(11));
				job.setExperience(resultSet.getString(12));
				job.setQualifications(resultSet.getString(13));
				job.setLastDate(resultSet.getDate(14).toString());

				jobs.add(job);
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return jobs;
	}
}
