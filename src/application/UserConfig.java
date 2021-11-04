package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javafx.beans.property.SimpleStringProperty;


// Klasse enthält alle Methoden für das Schreiben und Lesen von XML-Dateien
public class UserConfig
{
	// File mit Userdaten
	private static final String FILENAMEUSER = "./data/user.xml";
	// File mit Arbeitszeitdaten
	private static final String FILENAMETIME = "./data/worktime.xml";
	private static DocumentBuilderFactory dbf;
	private static InputStream is;
	private static Document doc;
	private static DocumentBuilder db;
	private static File xmlFile;

	// Öffne gewünschtes XML File zum lesen
	public static void openFile(String file)
	{
		try
		{
			dbf = DocumentBuilderFactory.newInstance();
			is = new FileInputStream(file);
			db = dbf.newDocumentBuilder();
			doc = db.parse(new InputSource(new InputStreamReader(is, "UTF-8")));
			xmlFile = new File(file);
		}
		catch (ParserConfigurationException | SAXException | IOException e)
		{
			e.printStackTrace();
		}

	}


	// Schließe File und schreibe Änderungen
	public static boolean closeFile()
	{
		try
		{
			Transformer transformer = createXmlTransformer();
			overwriteXmlFile(xmlFile, doc, transformer);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}


	// benötigt zum überschreiben einer XML Datei
	private static void overwriteXmlFile(File xmlFile, Document document,
		Transformer transformer) throws IOException, TransformerException
	{
		StreamResult result = new StreamResult(new PrintWriter(
			new FileOutputStream(xmlFile, false)));
		DOMSource source = new DOMSource(document);
		transformer.transform(source, result);
	}


	// benötigt zum überschreiben einer XML Datei
	private static Transformer createXmlTransformer() throws Exception
	{
		Transformer transformer = TransformerFactory.newInstance()
			.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.INDENT, "no");
		return transformer;
	}


	// lege neuen Benutzer in user.xml an und lösche alte gespeicherte Arbeitszeiten
	public boolean registerUser(String username, String password, String birthdate, char language, String worktime)
	{
		if (this.setUsername(username) && this.setPassword(password) && this.setBirthdate(birthdate) && this.setLanguage(language) && this.setWeeklyWorktime(worktime)
			&& this.setFirstWarning("10") && this.setSecondWarning("20") && this.newWorktime())
		{
			return true;
		}

		return false;

	}


	// Speichere Arbeitszeiten und Pausenzeiten für ausgewählten Tag in worktime.xml
	public boolean saveTime(LocalDate date, String timeBegin, String timeEnd, String breakTime, String extra)
	{

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();

		String dayString = "";
		String monthString = "";
		String yearString = "";

		yearString = String.valueOf(year);

		if (month < 10)
		{
			monthString = String.format("%02d", month);
		}
		else
		{
			monthString = String.valueOf(month);
		}

		if (day < 10)
		{
			dayString = String.format("%02d", day);
		}
		else
		{
			dayString = String.valueOf(day);
		}

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);

			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{
					Node item = childNodes.item(j);

					if (item.getNodeType() == Node.ELEMENT_NODE && item.getAttributes().getNamedItem("name").getNodeValue().equals(yearString))
					{

						NodeList monthNodes = item.getChildNodes();

						for (int k = 0; k < monthNodes.getLength(); k++)
						{
							Node monthItem = monthNodes.item(k);
							if (monthItem.getNodeType() == Node.ELEMENT_NODE && monthItem.getAttributes().getNamedItem("name").getNodeValue().equals(monthString))
							{

								NodeList dayNodes = monthItem.getChildNodes();

								for (int u = 0; u < dayNodes.getLength(); u++)
								{
									Node dayItem = dayNodes.item(u);
									if (dayItem.getNodeType() == Node.ELEMENT_NODE && dayItem.getAttributes().getNamedItem("name").getNodeValue().equals(dayString))
									{

										NodeList timeNodes = dayItem.getChildNodes();

										for (int v = 0; v < timeNodes.getLength(); v++)
										{
											Node timeItem = timeNodes.item(v);

											if ("begin".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent(timeBegin);
											}
											if ("end".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent(timeEnd);
											}
											if ("break".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent(breakTime);
											}
											if ("extra".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent(extra);
											}
											if ("overtime".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent("");
											}
											if ("reported".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent("0");
											}

										}
										break;
									}

									else if (u == dayNodes.getLength() - 1)
									{
										Node newDayItem = doc.createElement("day");
										Node lb = doc.createTextNode("\n");
										((Element) newDayItem).setAttribute("name", dayString);
										monthItem.appendChild(newDayItem);
										newDayItem.appendChild(lb);
										Node newBeginItem = doc.createElement("begin");
										Node newEndItem = doc.createElement("end");
										Node newBreakItem = doc.createElement("break");
										Node newExtraItem = doc.createElement("extra");
										Node newOTItem = doc.createElement("overtime");
										Node newRepItem = doc.createElement("reported");
										newBeginItem.setTextContent(timeBegin);
										newEndItem.setTextContent(timeEnd);
										newBreakItem.setTextContent(breakTime);
										newExtraItem.setTextContent(extra);
										newOTItem.setTextContent("");
										newRepItem.setTextContent("0");

										newDayItem.appendChild(newBeginItem);
										newDayItem.appendChild(newEndItem);
										newDayItem.appendChild(newBreakItem);
										newDayItem.appendChild(newExtraItem);
										newDayItem.appendChild(newOTItem);
										newDayItem.appendChild(newRepItem);
									}

								}
								break;
							}

							else if (k == monthNodes.getLength() - 1)
							{
								Node newMonthItem = doc.createElement("month");
								Node lb = doc.createTextNode("\n");
								((Element) newMonthItem).setAttribute("name", monthString);
								item.appendChild(newMonthItem);
								newMonthItem.appendChild(lb);
								k = -1;
							}

						}

						break;
					}
					else if (j == childNodes.getLength() - 1)
					{
						Node newYearItem = doc.createElement("year");
						Node lb = doc.createTextNode("\n");
						((Element) newYearItem).setAttribute("name", yearString);
						user.appendChild(newYearItem);
						newYearItem.appendChild(lb);
						j = -1;

					}
				}
			}

		}
		if (closeFile())
		{
			return true;
		}

		return false;

	}


	// Prüfe ob Login-Daten mit user.xml übereinstimmen
	public boolean login(String username, String password)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				String xmlUsername = "";
				String xmlPassword = "";

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("username"))
					{
						xmlUsername = childNodes.item(j).getTextContent();
					}
					if (childNodes.item(j).getNodeName().equals("password"))
					{
						xmlPassword = childNodes.item(j).getTextContent();
					}

				}

				if (!xmlUsername.equals("") && !xmlPassword.equals(""))
				{
					if (xmlUsername.equals(username) && xmlPassword.equals(password))
					{
						return true;
					}
				}

			}

		}

		return false;
	}


	// schreibe Gleitzeit für ausgewählten Tag in worktime.xml
	public boolean writeOvertime(LocalDate date, String overtime)
	{

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();

		String dayString = "";
		String monthString = "";
		String yearString = "";

		yearString = String.valueOf(year);

		if (month < 10)
		{
			monthString = String.format("%02d", month);
		}
		else
		{
			monthString = String.valueOf(month);
		}

		if (day < 10)
		{
			dayString = String.format("%02d", day);
		}
		else
		{
			dayString = String.valueOf(day);
		}

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);

			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{
					Node item = childNodes.item(j);

					if (item.getNodeType() == Node.ELEMENT_NODE && item.getAttributes().getNamedItem("name").getNodeValue().equals(yearString))
					{

						NodeList monthNodes = item.getChildNodes();

						for (int k = 0; k < monthNodes.getLength(); k++)
						{
							Node monthItem = monthNodes.item(k);
							if (monthItem.getNodeType() == Node.ELEMENT_NODE && monthItem.getAttributes().getNamedItem("name").getNodeValue().equals(monthString))
							{

								NodeList dayNodes = monthItem.getChildNodes();

								for (int u = 0; u < dayNodes.getLength(); u++)
								{
									Node dayItem = dayNodes.item(u);
									if (dayItem.getNodeType() == Node.ELEMENT_NODE && dayItem.getAttributes().getNamedItem("name").getNodeValue().equals(dayString))
									{

										NodeList timeNodes = dayItem.getChildNodes();

										for (int v = 0; v < timeNodes.getLength(); v++)
										{
											Node timeItem = timeNodes.item(v);

											if ("overtime".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent(overtime);
											}

										}

									}

								}

							}

						}

					}

				}
			}

		}
		if (closeFile())
		{
			return true;
		}

		return false;

	}


	// schreibe Meldestatus für ausgewählten Tag in worktime.xml
	public boolean writeReported(LocalDate date, String reported)
	{

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();

		String dayString = "";
		String monthString = "";
		String yearString = "";

		yearString = String.valueOf(year);

		if (month < 10)
		{
			monthString = String.format("%02d", month);
		}
		else
		{
			monthString = String.valueOf(month);
		}

		if (day < 10)
		{
			dayString = String.format("%02d", day);
		}
		else
		{
			dayString = String.valueOf(day);
		}

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);

			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{
					Node item = childNodes.item(j);

					if (item.getNodeType() == Node.ELEMENT_NODE && item.getAttributes().getNamedItem("name").getNodeValue().equals(yearString))
					{

						NodeList monthNodes = item.getChildNodes();

						for (int k = 0; k < monthNodes.getLength(); k++)
						{
							Node monthItem = monthNodes.item(k);
							if (monthItem.getNodeType() == Node.ELEMENT_NODE && monthItem.getAttributes().getNamedItem("name").getNodeValue().equals(monthString))
							{

								NodeList dayNodes = monthItem.getChildNodes();

								for (int u = 0; u < dayNodes.getLength(); u++)
								{
									Node dayItem = dayNodes.item(u);
									if (dayItem.getNodeType() == Node.ELEMENT_NODE && dayItem.getAttributes().getNamedItem("name").getNodeValue().equals(dayString))
									{

										NodeList timeNodes = dayItem.getChildNodes();

										for (int v = 0; v < timeNodes.getLength(); v++)
										{
											Node timeItem = timeNodes.item(v);

											if ("reported".equalsIgnoreCase(timeItem.getNodeName()))
											{
												timeItem.setTextContent(reported);
											}

										}

									}

								}

							}

						}

					}

				}
			}

		}
		if (closeFile())
		{
			return true;
		}

		return false;

	}


	// hole Daten aus worktime.xml für Kalender-Tabelle des Programms
	public List<Person> getTimes()
	{

		List<Person> workdays = new ArrayList<Person>();

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);

			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{
					Node item = childNodes.item(j);

					if (item.getNodeType() == Node.ELEMENT_NODE && item.getNodeName().equals(String.valueOf("year")))
					{

						String year = item.getAttributes().getNamedItem("name").getNodeValue();
						NodeList monthNodes = item.getChildNodes();

						for (int k = 0; k < monthNodes.getLength(); k++)
						{
							Node monthItem = monthNodes.item(k);
							if (monthItem.getNodeType() == Node.ELEMENT_NODE && monthItem.getNodeName().equals(String.valueOf("month")))
							{
								String month = monthItem.getAttributes().getNamedItem("name").getNodeValue();
								NodeList dayNodes = monthItem.getChildNodes();

								for (int u = 0; u < dayNodes.getLength(); u++)
								{
									Node dayItem = dayNodes.item(u);
									if (dayItem.getNodeType() == Node.ELEMENT_NODE && dayItem.getNodeName().equals(String.valueOf("day")))
									{
										Person p1 = new Person();
										String day = dayItem.getAttributes().getNamedItem("name").getNodeValue();
										NodeList timeNodes = dayItem.getChildNodes();
										LocalDate date = LocalDate.parse(year + "-" + month + "-" + day);
										p1.setBirthday(date);
										for (int v = 0; v < timeNodes.getLength(); v++)
										{

											if (timeNodes.item(v).getNodeName().equals("begin"))
											{
												p1.setArbeitsbeginn(new SimpleStringProperty(timeNodes.item(v).getTextContent()));
											}
											if (timeNodes.item(v).getNodeName().equals("end"))
											{
												p1.setArbeitsende(new SimpleStringProperty(timeNodes.item(v).getTextContent()));
											}
											if (timeNodes.item(v).getNodeName().equals("extra"))
											{
												p1.setPause(new SimpleStringProperty(timeNodes.item(v).getTextContent()));
											}
											if (timeNodes.item(v).getNodeName().equals("overtime"))
											{
												p1.setOvertime(new SimpleStringProperty(timeNodes.item(v).getTextContent()));
											}

										}

										workdays.add(p1);
									}
								}
							}
						}
					}
				}

			}

		}
		return workdays;
	}


	// setze neues Passwort
	public boolean newPassword(String oldPass, String newPass)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("password"))
					{
						if (childNodes.item(j).getTextContent().equals(oldPass))
						{

							childNodes.item(j).setTextContent(newPass);

						}
						else
						{
							return false;
						}
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// ändere Sprache
	public boolean setLanguage(char sprache)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("language"))
					{

						childNodes.item(j).setTextContent(Character.toString(sprache));
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// setze Wochenarbeitszeit
	public boolean setWeeklyWorktime(String worktime)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("worktime"))
					{

						childNodes.item(j).setTextContent(worktime);
					}

				}

			}

		}

		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// setzte Benutzername
	public boolean setUsername(String username)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("username"))
					{

						childNodes.item(j).setTextContent(username);
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// setze Passwort
	public boolean setPassword(String password)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("password"))
					{

						childNodes.item(j).setTextContent(password);
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// setze Geburtstag
	public boolean setBirthdate(String birthdate)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("birthdate"))
					{

						childNodes.item(j).setTextContent(birthdate);
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// setze erste Warnstufe für Ampellogik
	public boolean setFirstWarning(String firstWarning)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("firstWarning"))
					{

						childNodes.item(j).setTextContent(firstWarning);
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// setze zweite Warnstufe für Ampellogik
	public boolean setSecondWarning(String secondWarning)
	{

		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("secondWarning"))
					{

						childNodes.item(j).setTextContent(secondWarning);
					}

				}

			}

		}
		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// leere worktime.xml
	public boolean newWorktime()
	{

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node node = listOfUser.item(i);

			while (node.hasChildNodes())
			{
				node.removeChild(node.getFirstChild());
			}
			Node lb = doc.createTextNode("\n");
			node.appendChild(lb);
		}

		if (closeFile())
		{
			return true;
		}
		return false;
	}


	// hole eingestellte Sprache
	public int getLanguage()
	{

		int lang = 0;
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("language"))
					{
						if (childNodes.item(j).getTextContent().equals("e"))
						{
							lang = 1;
						}
					}

				}

			}

		}

		return lang;
	}


	// hole Geburtsdatum
	public String getBirthday()
	{

		String bd = "";
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("birthdate"))
					{
						bd = childNodes.item(j).getTextContent();
					}

				}

			}

		}

		return bd;
	}


	// hole erste Warnstufe für Ampellogik
	public int getFirstWarning()
	{

		int fw = 0;
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("firstWarning"))
					{
						try
						{
							fw = Integer.parseInt(childNodes.item(j).getTextContent());
						}
						catch (Exception e)
						{
							return -1;
						}
					}

				}

			}

		}

		return fw;
	}


	// hole zweite Warnstufe für Ampellogik
	public int getSecondWarning()
	{

		int sw = 0;
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("secondWarning"))
					{
						try
						{
							sw = Integer.parseInt(childNodes.item(j).getTextContent());
						}
						catch (Exception e)
						{
							return 9999;
						}
					}

				}

			}

		}

		return sw;
	}


	// hole Wochenarbeitszeit
	public String getWorktime()
	{

		String wt = "";
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("worktime"))
					{
						wt = childNodes.item(j).getTextContent();
					}

				}

			}

		}

		return wt;
	}


	// hole Passwort
	public String getPassword()
	{

		String pw = "";
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("password"))
					{
						pw = childNodes.item(j).getTextContent();
					}

				}

			}

		}

		return pw;
	}


	// hole Benutzername
	public String getUsername()
	{

		String un = "";
		openFile(FILENAMEUSER);

		NodeList listOfUser = doc.getElementsByTagName("user");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);
			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{

					if (childNodes.item(j).getNodeName().equals("username"))
					{
						un = childNodes.item(j).getTextContent();
					}

				}

			}

		}

		return un;
	}


	// hole Meldestatus für Farbgebung in Kalender
	public int getReported(LocalDate date)
	{

		int reported = 0;

		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();

		String dayString = "";
		String monthString = "";
		String yearString = "";

		yearString = String.valueOf(year);

		if (month < 10)
		{
			monthString = String.format("%02d", month);
		}
		else
		{
			monthString = String.valueOf(month);
		}

		if (day < 10)
		{
			dayString = String.format("%02d", day);
		}
		else
		{
			dayString = String.valueOf(day);
		}

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);

			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{
					Node item = childNodes.item(j);

					if (item.getNodeType() == Node.ELEMENT_NODE && item.getAttributes().getNamedItem("name").getNodeValue().equals(yearString))
					{

						NodeList monthNodes = item.getChildNodes();

						for (int k = 0; k < monthNodes.getLength(); k++)
						{
							Node monthItem = monthNodes.item(k);
							if (monthItem.getNodeType() == Node.ELEMENT_NODE && monthItem.getAttributes().getNamedItem("name").getNodeValue().equals(monthString))
							{

								NodeList dayNodes = monthItem.getChildNodes();

								for (int u = 0; u < dayNodes.getLength(); u++)
								{
									Node dayItem = dayNodes.item(u);
									if (dayItem.getNodeType() == Node.ELEMENT_NODE && dayItem.getAttributes().getNamedItem("name").getNodeValue().equals(dayString))
									{

										NodeList timeNodes = dayItem.getChildNodes();

										for (int v = 0; v < timeNodes.getLength(); v++)
										{
											Node timeItem = timeNodes.item(v);

											if ("reported".equalsIgnoreCase(timeItem.getNodeName()))
											{
												String rp = timeItem.getTextContent();
												try
												{
													reported = Integer.parseInt(rp);
												}
												catch (Exception e)
												{
													return 0;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return reported;
	}


	// hole Arbeitsbeginn, Arbeitsende, Pause und Extrapause für Gleitzeitberechnung
	public String[] getDayData(LocalDate date)
	{

		String[] begin = { "", "", "", "" };

		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();

		String dayString = "";
		String monthString = "";
		String yearString = "";

		yearString = String.valueOf(year);

		if (month < 10)
		{
			monthString = String.format("%02d", month);
		}
		else
		{
			monthString = String.valueOf(month);
		}

		if (day < 10)
		{
			dayString = String.format("%02d", day);
		}
		else
		{
			dayString = String.valueOf(day);
		}

		openFile(FILENAMETIME);

		NodeList listOfUser = doc.getElementsByTagName("worktime");

		for (int i = 0; i < listOfUser.getLength(); i++)
		{

			Node user = listOfUser.item(i);

			if (user.getNodeType() == Node.ELEMENT_NODE)
			{

				NodeList childNodes = user.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++)
				{
					Node item = childNodes.item(j);

					if (item.getNodeType() == Node.ELEMENT_NODE && item.getAttributes().getNamedItem("name").getNodeValue().equals(yearString))
					{

						NodeList monthNodes = item.getChildNodes();

						for (int k = 0; k < monthNodes.getLength(); k++)
						{
							Node monthItem = monthNodes.item(k);
							if (monthItem.getNodeType() == Node.ELEMENT_NODE && monthItem.getAttributes().getNamedItem("name").getNodeValue().equals(monthString))
							{

								NodeList dayNodes = monthItem.getChildNodes();

								for (int u = 0; u < dayNodes.getLength(); u++)
								{
									Node dayItem = dayNodes.item(u);
									if (dayItem.getNodeType() == Node.ELEMENT_NODE && dayItem.getAttributes().getNamedItem("name").getNodeValue().equals(dayString))
									{

										NodeList timeNodes = dayItem.getChildNodes();

										for (int v = 0; v < timeNodes.getLength(); v++)
										{
											Node timeItem = timeNodes.item(v);

											if ("begin".equalsIgnoreCase(timeItem.getNodeName()))
											{
												begin[0] = timeItem.getTextContent();
											}
											if ("end".equalsIgnoreCase(timeItem.getNodeName()))
											{
												begin[1] = timeItem.getTextContent();
											}
											if ("break".equalsIgnoreCase(timeItem.getNodeName()))
											{
												begin[2] = timeItem.getTextContent();
											}
											if ("extra".equalsIgnoreCase(timeItem.getNodeName()))
											{
												begin[3] = timeItem.getTextContent();
											}

										}
									}
								}
							}
						}
					}
				}
			}
		}
		return begin;
	}
}
