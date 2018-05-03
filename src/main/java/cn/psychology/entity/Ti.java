 package cn.psychology.entity;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.util.*;


 @Document(collection="TestCollection")
public class Ti  implements Serializable {

    @Id
    private String id;

    @Field("examination")
        private String examination;
    @Field("examinationName")
       private String examinationName;
    @Field("Question_List")
        private ArrayList<obj> Question_ListObj;
    @Field("Answer")
     private ArrayList<obja> Answer;

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getExamination() {
         return examination;
     }

     public void setExamination(String examination) {
         this.examination = examination;
     }

     public String getexaminationName() {
         return examinationName;
     }

     public void setexaminationName(String Name) {
         examinationName = Name;
     }

     public ArrayList<obj> getQuestion_ListObj() {
         return Question_ListObj;
     }

     public void setQuestion_ListObj(ArrayList<obj> question_ListObj) {
         Question_ListObj = question_ListObj;
     }

     public ArrayList<obja> getAnswer() {
         return Answer;
     }

     public void setAnswer(ArrayList<obja> answer) {
         Answer = answer;
     }

     public class obj{
         String Questionid;
        String Question;
        String AnswerOne;
        String AnswerTwo;
        String AnswerThree;
        String AnswerFour;

        public String getQuestion_id() {
            return Questionid;
        }

        public void setQuestion_d(String questionid) {
            Questionid = questionid;
        }

        public String getQuestion() {
            return Question;
        }

        public void setQuestion(String question) {
            Question = question;
        }

        public String getAnswerOne() {
            return AnswerOne;
        }

        public void setAnswerOne(String answerOne) {
            AnswerOne = answerOne;
        }

        public String getAnswerTwo() {
            return AnswerTwo;
        }

        public void setAnswerTwo(String answerTwo) {
            AnswerTwo = answerTwo;
        }

        public String getAnswerThree() {
            return AnswerThree;
        }

        public void setAnswerThree(String answerThree) {
            AnswerThree = answerThree;
        }

        public String getAnswerFour() {
            return AnswerFour;
        }

        public void setAnswerFour(String answerFour) {
            AnswerFour = answerFour;
        }
    }
    public class obja{
        public String getOptionid() {
            return Optionid;
        }

        public void setOptionid(String optionid) {
            Optionid = optionid;
        }

        public String getOptioncontent() {
            return Optioncontent;
        }

        public void setOptioncontent(String optioncontent) {
            Optioncontent = optioncontent;
        }

        String Optionid;
        String Optioncontent;

    }

     public Ti() {
     }


 }
