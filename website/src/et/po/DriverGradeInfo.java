package et.po;



/**
 * DriverGradeInfo generated by MyEclipse - Hibernate Tools
 */

public class DriverGradeInfo  implements java.io.Serializable {


    // Fields    

     private String id;
     private String classId;
     private String classStuId;
     private String gradeName;
     private String gradeValue;


    // Constructors

    /** default constructor */
    public DriverGradeInfo() {
    }

	/** minimal constructor */
    public DriverGradeInfo(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public DriverGradeInfo(String id, String classId, String classStuId, String gradeName, String gradeValue) {
        this.id = id;
        this.classId = classId;
        this.classStuId = classStuId;
        this.gradeName = gradeName;
        this.gradeValue = gradeValue;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getClassId() {
        return this.classId;
    }
    
    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassStuId() {
        return this.classStuId;
    }
    
    public void setClassStuId(String classStuId) {
        this.classStuId = classStuId;
    }

    public String getGradeName() {
        return this.gradeName;
    }
    
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeValue() {
        return this.gradeValue;
    }
    
    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }
   








}