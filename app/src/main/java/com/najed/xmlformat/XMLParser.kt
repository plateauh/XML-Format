package com.najed.xmlformat

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream
import java.lang.Exception

class XMLParser {

    private var text: String? = null

    private lateinit var students: ArrayList<Student>
    private var studentID = 0
    private var studentName = ""
    private var studentMark = 0f

    fun parse(stream: InputStream): ArrayList<Student> {
        students = arrayListOf()
        try {
            val parser = XmlPullParserFactory.newInstance().newPullParser()
            parser.setInput(stream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT){
                val tagName = parser.name
                when (eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> endTag(tagName)
                }
                eventType = parser.next()
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
        return students
    }

    private fun endTag(tagName: String){
        when {
            tagName.equals("id", true) -> {
                studentID = text!!.toInt()
            }
            tagName.equals("name", true) -> {
                studentName = text.toString()
            }
            tagName.equals("marks", true) -> {
                studentMark = text!!.toFloat()
            }
            tagName.equals("StudentDetails", true) -> { }
            else -> {
                students.add(Student(studentID, studentName, studentMark))
            }
        }
    }
}