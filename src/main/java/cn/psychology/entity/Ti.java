package cn.psychology.entity;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.util.*;


@Document(collection = "TestCollection")
public class Ti implements Serializable {

    @Id
    private String id;

    //    @Field("examination")
//        private String examination;
//    @Field("examinationName")
//       private String examinationName;
//    @Field("Question_List")
//        private ArrayList<obj> Question_ListObj;
//    @Field("Answer")
//     private ArrayList<obja> Answer;
//
//
//
//     public class obj{
//         String Questionid;
//        String Question;
//        String AnswerOne;
//        String AnswerTwo;
//        String AnswerThree;
//        String AnswerFour;
//
//
//    }
//    public class obja{
//
//        String Optionid;
//        String Optioncontent;
//
//    }
    @Field("examinationId")
    private String examinationId;


    @Field("examinationName")
    private String examinationName;
    @Field("questionsMessage")
    private ArrayList<QueMessage> questionsMessage;
    @Field("questionsConclusion")
    private ArrayList<QueConclusion> questionsConclusion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    public ArrayList<QueMessage> getQuestionsMessage() {
        return questionsMessage;
    }

    public void setQuestionsMessage(ArrayList<QueMessage> questionsMessage) {
        this.questionsMessage = questionsMessage;
    }

    public ArrayList<QueConclusion> getQuestionsConclusion() {
        return questionsConclusion;
    }

    public void setQuestionsConclusion(ArrayList<QueConclusion> questionsConclusion) {
        this.questionsConclusion = questionsConclusion;
    }

    public class QueMessage {
        @Field("questionId")
        String questionId;

        @Field("questionName")
        String questionName;
        @Field("questionOptions")
        ArrayList<ObjOption> questionOptions;
        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public String getQuestionName() {
            return questionName;
        }

        public void setQuestionName(String questionName) {
            this.questionName = questionName;
        }

        public ArrayList<ObjOption> getQuestionOptions() {
            return questionOptions;
        }

        public void setQuestionOptions(ArrayList<ObjOption> questionOptions) {
            this.questionOptions = questionOptions;
        }

        public class ObjOption{
                @Field("optionName")
                String optionName;
                @Field("optionValue")
                String optionValue;

            public ObjOption(String optionName, String optionValue) {
                this.optionName = optionName;
                this.optionValue = optionValue;
            }

            public String getOptionName() {
                    return optionName;
                }

                public void setOptionName(String optionName) {
                    this.optionName = optionName;
                }

            public String getOptionValue() {
                return optionValue;
            }

            public void setOptionValue(String optionValue) {
                this.optionValue = optionValue;
            }
        }



    }

    public class QueConclusion {
        String conclusionId;
        String scoreRange;
        String queConclusion;

        public String getConclusionId() {
            return conclusionId;
        }

        public void setConclusionId(String conclusionId) {
            this.conclusionId = conclusionId;
        }

        public String getScoreRange() {
            return scoreRange;
        }

        public void setScoreRange(String scoreRange) {
            this.scoreRange = scoreRange;
        }

        public String getQueConclusion() {
            return queConclusion;
        }

        public void setQueConclusion(String queConclusion) {
            this.queConclusion = queConclusion;
        }


    }



    public Ti() {
    }

}
