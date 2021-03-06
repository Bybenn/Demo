package com.example.demoproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context myContext;
    public static final String DATABASE_NAME = "projectdatabase.db";

    public static final String TABLE_NAME = "registeruser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    public static final String COL_4 = "morning";
    public static final String COL_5 = "afternoon";
    public static final String COL_6 = "evening";

    private static final String tableCreateSQL = "CREATE TABLE todo_list ("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "todo_text1 TEXT," +
            "todo_text2 TEXT," +
            "todo_text3 TEXT," +
            "todo_text4 TEXT" +");";

    private static final String tableYourMED = "CREATE TABLE you_med ("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "medname TEXT," +
            "medinfo TEXT" +");";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT," +
                " username TEXT, password TEXT, morning TEXT, afternoon TEXT, evening TEXT)");

        sqLiteDatabase.execSQL(tableCreateSQL);
        String Data1 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Smecta','  แก้ท้องเสีย เป็นสารดูดซับทางลำไส้ สามารถเคลือบเยื่อบุเมือกของทางเดินอาหารได้','  ควรทานหลังอาหาร ผสมน้ำ 50 มิลลิลิตรหรืออาหารเหลว 3 กรัมไม่ควรทานพร้อมกับยาตัวอื่นๆ\n    ผู้ใหญ่ 1 ซองวันละ 3-4 ครั้ง\n    เด็ก <1 ปีวันละ 2 ซอง 3 วันแล้วลดเหลือวันละ 1 ซอง\n    เด็ก >1 ปีวันละ 4 ซอง 3 วันแล้วลดเหลือวันละ 2 ซอง','02');";
        String Data2 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Bioflor','  แก้ท้องเสีย ช่วยปรับสมดุลของจุลินทรีย์ในทางเดินอาหาร ต้านแบคทีเรียที่ไม่ดีและสามารถสังเคราะห์วิตามินบีได้','  ควรทานหลังอาหาร 1-2 ซอง วันละ 1-2 ครั้งและตัวยาควรผสมน้ำเปล่าหรือน้ำหวาน \n**ห้ามผสมน้ำร้อน**','02');";
        String Data3 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Dehecta','  เป็นยาน้ำแขวนตะกอนขนาด 3 กรัมปริมาตร 20 มิลลิลิตรแก้ท้องเสียเป็นสารดูดซับทางลำไส้ สามารถเคลือบเยื่อบุเมือกของทางเดินอาหารได้','  ควรทานผสมน้ำ 50 มิลลิกรัม หรืออาหารเหลว 3 กรัม และทานหลังมื้ออาหาร ไม่ควรทานพร้อมกับยาตัวอื่นๆ\n    ผู้ใหญ่ 1 ซองวันละ 3-4 ครั้ง\n    เด็ก <1 ปีวันละ 2 ซอง 3 วันแล้วลดเหลือวันละ 1 ซอง\n    เด็ก >1 ปีขึ้นไปวันละ 4 ซอง 3 วันแล้วลดเหลือวันละ 2 ซอง','02');";
        String Data4 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Infloran','  ปรับความสมดุลของจุลินทรีย์ในลำไส้ ซึ่งควรรับประทานในปริมาณที่พอเหมาะจะช่วยส่งเสริมสุขภาพของร่างกาย','  รับประทาน 1 แคปซูลหลังอาหารวันละสามครั้งต่อเนื่องประมาณ 3-5 วัน','02');";
        String Data5 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Domperidone','  บรรเทาอาการคลื่นไส้ อาเจียน และอาการจากอาหารไม่ย่อย','  ควรทานก่อนมื้ออาหาร 30 นาทีและไม่ควรใช้ยานี้ติดต่อกันเกิน 7 วัน\n    ผู้ใหญ่ รับประทานยาครั้งละ 10-20 มิลลิกรัม วันละ 3 ครั้ง ห้ามรับประทานยานี้เกินกว่า 80 มิลลิกรัม/วัน และไม่เกิน 3 ครั้งภายใน 24 ชั่วโมง\n    ทารกและเด็กเล็กและเด็กที่มีน้ำหนักน้อยกว่า 35 กิโลกรัม ไม่ควรรับประทานยานี้ หากจำเป็นควรรับประทาน 0.25-0.5 มิลลิกรัมต่อน้ำหนักตัว 1 กิโลกรัม วันละ 3-4 ครั้ง','01');";
        String Data6 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Buscopan','  ใช้เป็นยาแก้อาการปวดเกร็งหรือบิดเกร็งของอวัยวะในช่องท้อง เช่น ท้องเดิน ท้องเสีย หรืออุจจาระร่วง อาการปวดท้องเนื่องจากนิ่วในน้ำดี-ท่อไต โรคลำไส้แปรปรวน  ปวดประจำเดือน เป็นต้น','  ควรทานเมื่อมีอาการ และรับประทานยาซ้ำได้ทุก ๆ 6-8 ชั่ว โมง (ไม่เกินวันละ 4 ครั้ง ในผู้ใหญ่ และไม่เกินวันละ 3 ครั้ง ในเด็ก)\n    ผู้ใหญ่ รับประทานยาครั้งละ 10-20 มิลลิกรัม\n    เด็กอายุต่ำกว่า 1 ปี ให้รับประทานยาครั้งละ ¼-½ ช้อนชา\n    เด็กอายุ 1-4 ปี ให้รับประทานยาครั้งละ ½-1 ช้อนชา\n    เด็กอายุ 4-7 ปี ให้รับประทานยาครั้ง ½-1 เม็ด\n    เด็กอายุ 7-12 ปี ให้รับประทานยาครั้งละ 1 เม็ด','04');";
        String Data7 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Chlorpheniramine','  อยู่ในกลุ่มยาแก้แพ้ ออกฤทธิ์โดยต้านการทำงานของสารฮีสทามีนซึ่งเป็นสารที่ระบบภูมิคุ้มกันของร่างกายสร้างขึ้นและก่อให้เกิดปฏิกิริยาต่อภูมิแพ้ บรรเทาอาการจากหวัด จาม น้ำมูกไหล น้ำตาไหล อาการคัน รวมถึงไข้หวัดใหญ่','  ควรทานเมื่อมีอาการ\n    เด็ก 2-5 ปี ปริมาณ 1 มิลลิกรัม ทุก 4-6 ชั่วโมง (ปริมาณสูงสุดไม่เกิน 6 มิลลิกรัม/วัน)\n    เด็ก 6-11 ปี ปริมาณ 2 มิลลิกรัม ทุก 4-6 ชั่วโมง (ปริมาณสูงสุดไม่เกิน 16 มิลลิกรัม/วัน)\n    เด็ก 12 ปีขึ้นไป ปริมาณ 4 มิลลิกรัม ทุก 4-6 ชั่วโมง (ปริมาณสูงสุดไม่เกิน 32 มิลลิกรัม/วัน)\n    ผู้ใหญ่ ปริมาณ 4 มิลลิกรัม ทุก 4-6 ชั่วโมง (ปริมาณสูงสุดไม่เกิน 32 มิลลิกรัม/วัน)','04');";
        String Data8 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Bayer Aspirin','  บรรเทาอาการปวด ลดไข้ ลดการอักเสบ เช่น ปวดศีรษะ ปวดฟัน ปวดประจำเดือน เป็นไข้ หากใช้ในปริมาณต่ำจะช่วยต้านเกล็ดเลือด ลดการเกิดลิ่มเลือด อาการเจ็บหน้าอกภาวะหัวใจล้มเหลว หรือโรคหลอดเลือดในสมอง เป็นต้น','  ควรรับประทานเมื่อมีอาการ\n    ผู้ใหญ่ รับประทานยาขนาด 325-650 มิลลิกรัม ทุก 4-6 ชั่วโมง สูงสุดไม่เกิน 4 กรัมต่อวัน','04');";
        String Data9 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Ergotamine','  รักษาอาการปวดศีรษะจากไมเกรน','  ควรทานเมื่อมีอาการ\n    เด็กอายุ 6-12 ปี ทานครั้งแรก1 มิลลิกรัมเพิ่มปริมาณครั้งละ 1 มิลลิกรัม ทุก 30 นาทีจนทุเลา\n    (ปริมาณสูงสุดไม่เกิน 3 มิลลิกรัม/วัน และไม่เกิน 5 มิลลิกรัม/สัปดาห์)\n    ผู้ใหญ่ ทานครั้งแรก2 มิลลิกรัมเพิ่มปริมาณครั้งละ 1 มิลลิกรัม ทุก 30 นาทีจนทุเลา (ปริมาณสูงสุดไม่เกิน 6 มิลลิกรัม/วัน และไม่เกิน 10 มิลลิกรัม/สัปดาห์)','04');";
        String Data10 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Diphenhydramine','  ใช้รักษาโรคภูมิแพ้ ไข้ละอองฟาง หรือไข้หวัด ช่วยยับยั้งไม่ให้เกิดอาการแพ้ต่างๆเช่น ไอ จาม น้ำมูกไหล น้ำตาไหล ตาแดง ลมพิษ ผื่นผิวหนัง คันหรืออาการหวัดและอาการแพ้อื่น ๆ และยังสามารถบรรเทาอาการเมารถยานพาหนะได้้','  ควรทานเมื่อมีอาการ ส่วนสำหรับการป้องกันอาการเมายานพาหนะ ควรทานก่อนการเดินทาง  30 นาที\n    ผู้ใหญ่รับประทานขนาด 25-50 มิลลิกรัม 3-4 ครั้งต่อวัน ก่อนเดินทาง ปริมาณสูงสุด 300 มิลลิกรัมต่อวัน\n    เด็กอายุ 2-6 ปี รับประทานขนาด 6.25 มิลลิกรัม ทุก 4-6 ชั่วโมง \n       อายุ 6-12 ปี รับประทานขนาด 12.5-25 มิลลิกรัม ทุก 4-6 ชั่วโมง','04');";
        String Data11 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Loratadine','  บรรเทาอาการคัน ผื่นแดง จาม น้ำมูกไหล น้ำตาไหล รวมทั้งอาการจากหวัดและภูมิแพ้ทั้งหลาย','  ควรทานเมื่อมีอาการ ปกติยานี้ใช้รับประทานเพียงวันละหนึ่งครั้งเท่านั้นและควรใช้ยาในปริมาณและระยะเวลาตามฉลากกำกับหรือแพทย์สั่ง \n    เด็กอายุ 2-5 ปี (ยาน้ำเชื่อม) 5 มิลลิกรัม\n    เด็กอายุมากกว่า 6 ปีและผู้ใหญ่ (ยาเม็ด แคปซูล ยาละลายในช่องปาก) 10 มิลลิกรัมหรือ 5 มิลลิกรัมทุก 12 ชั่วโมง','04');";
        String Data12 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Bisovol','  ช่วยละลายเสมหะในระบบทางเดินหายใจ บรรเทาอาการไอจากโรคหวัด ไอมีเสมหะ','  ควรทานพร้อมอาหารหรือหลังอาหาร\n    ผู้ใหญ่ ยาเม็ดรับประทานยาในปริมาณ 8-16 มิลลิกรัม วันละ 3 ครั้ง\n    เด็กอายุ 2-5 ปี รับประทานยาในปริมาณ 8 มิลลิกรัม โดยแบ่งรับประทานวันละ 2-3 ครั้งต่อวัน \n       อายุ 6-11 ปี รับประทานยาในปริมาณ 4-8 มิลลิกรัม โดยแบ่งรับประทานวันละ 3 ครั้ง \n       อายุมากกว่า 12 ปี รับประทานยาในปริมาณ 8-16 มิลลิกรัม วันละ 3 ครั้ง (ยาน้ำความเข้มข้น 4 มิลลิกรัม/5 มิลลิลิตร)','02');";
        String Data13 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Diazepam','  ใช้เพื่อคลายความวิตกกังวลอันเป็นสาเหตุหนึ่งของปัญหานอนไม่หลับและยังใช้เพื่อรักษาผู้ป่วยโรควิตกกังวล อาการถอนพิษยาจากแอลกอฮอล์ อาการกล้ามเนื้อกระตุก ลดความวิตกกังวลก่อนการผ่าตัด รักษาอาการตกใจกลัวอย่างรุนแรงและใช้ร่วมกับยาตัวอื่นเพื่อรักษาภาวะชักได้ด้วย','  ขนาดยาที่ใช้ในการรักษาแตกต่างกันไป ขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\nการรักษาความวิตกกังวล\n    ผู้ใหญ่รับประทาน 2-10 มิลลิกรัม 3 ครั้ง/วัน ไม่รับประทานเกิน 30 มิลลิกรัม/วัน\n    เด็กรับประทาน 1-2.5 มิลลิกรัม 3-4 ครั้ง/วัน\n การรักษาอาการนอนไม่หลับ\n    ผู้ใหญ่ ยารับประทาน 5-15 มิลลิกรัม ก่อนนอน\n    เด็ก 1-2.5 มิลลิกรัม 3-4 ครั้ง/วัน','03');";
        String Data14 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Valium Diazepam','  ใช้เป็นยากล่อมประสาท ช่วยผ่อนคลายความวิตกกังวล ลดความตึงเครียด ตื่นเต้น ใจสั่น รวมทั้งใช้รักษาโรคที่เกิดจากความเครียดต่างๆ เช่น การปวดศีรษะจากความเครียด ไมเกรน อาการฟุ้งซ่านที่เกิดจากโรคประสาท โรคลำไส้แปรปรวน อาหารไม่ย่อย เป็นยานอนหลับในกรณีที่นอนไม่หลับเนื่องจากมีความกังวล ใช้คลายกล้ามเนื้อหรือคลายเส้นและใช้รักษาอาการที่เกิดจากภาวะขาดสุราเฉียบพลัน เป็นต้น','  ควรทานหลังอาการหรือก่อนนอน ขนาดยาที่ใช้ในการรักษาแตกต่างกันไปขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\nใช้กล่อมประสาทและคลายกล้ามเนื้อ \n    ผู้ใหญ่ให้ใช้ยานี้วันละ 4-40 มิลลิกรัม \n    เด็กให้ใช้วันละ 3-10 มิลลิกรัม \n    ผู้สูงอายุให้ใช้วันละ 2-5 มิลลิกรัม โดยแบ่งให้วันละ 1-4 \nใช้เป็นยาช่วยให้นอนหลับ \n    ผู้ใหญ่ให้ใช้ยาครั้งละ 5-20 มิลลิกรัม \n    เด็กให้ใช้ครั้งละ 2-10 มิลลิกรัม โดยให้รับประทานยาในเวลาที่ต้องการจะนอนหลับก่อนครึ่งชั่วโมง \nใช้รักษาอาการที่เกิดจากภาวะขาดสุราเฉียบพลัน\n    ผู้ใหญ่ ใน 24 ชั่วโมงแรก ให้รับประทานยาครั้งละ 10 มิลลิกรัม โดยแบ่งให้วันละ 3-4 ครั้งวันต่อมาให้ลดขนาดลงเหลือครั้งละ 5 มิลลิกรัมโดยแบ่งให้วันละ 3-4 ครั้งเช่นกัน','03');";
        String Data15 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Fluoxetine','  รักษาอาการจากภาวะซึมเศร้า โรคตื่นตะหนก โรคย้ำคิดย้ำทำ โรคบูลิเมียและกลุ่มอาการอารมณ์ผิดปกติก่อนมีประจำเดือน','  ควรทานเมื่อมีอาการ\n    ผู้ใหญ่ เบื้องต้นรับประทานครั้งละ 20 มิลลิกรัม วันละครั้งและสามารถเพิ่มปริมาณยาที่ใช้ หากอาการยังไม่ดีขึ้นในอีกหลายสัปดาห์ต่อมาโดยปริมาณยาสูงสุดไม่เกิน 80 มิลลิกรัม/วัน \nส่วนปริมาณสำหรับการรักษาอย่างต่อเนื่องอยู่ที่ 20-60 มิลลิกรัม/วัน\n    เด็กอายุ 8-18 ปี เบื้องต้นรับประทานครั้งละ 10 มิลลิกรัม วันละครั้งหลังจากผ่านไป 1-2 สัปดาห์อาจค่อยๆเพิ่มปริมาณเป็น 20 มิลลิกรัม/วันแต่หากเด็กมีน้ำหนักตัวน้อยให้ทานเบื้องต้น 10 มิลลิกรัมวันละครั้งและเพิ่มเป็น 20 มิลลิกรัม/วัน','04');";
        String Data16 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Zoloft','  ใช้ยานี้ในการรักษาโรคซึมเศร้า โรคย้ำคิดย้ำทำ โรคแพนิกหรือโรคตื่นตระหนก โรคเครียดจากเหตุการณ์ร้ายแรง และกลุ่มอาการผิดปกติรุนแรงก่อนมีประจำเดือน','  ควรทานเมื่อมีอาการและขนาดยาที่ใช้ในการรักษาแตกต่างกันไป\nขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\nโรคซึมเศร้าหรือโรคย้ำคิดย้ำทำ\nผู้ใหญ่รับประทาน 50 มิลลิกรัม วันละ 1 ครั้ง\nเด็กอายุ 6-12 ปี เริ่มต้นด้วยขนาดยา 25 มิลลิกรัมวันละ 1 ครั้ง\nเด็กอายุ 13-17 ปีเริ่มต้นขนาดยา 50 มิลลิกรัมวันละ 1 ครั้ง\nโรคตื่นตระหนกหรือโรคเครียดหลังประสบเหตุการณ์สะเทือนใจ\nผู้ใหญ่เริ่มต้นขนาดยา 25 มิลลิกรัมวันละ 1 ครั้ง \nติดต่อเป็นระยะเวลาหนึ่งสัปดาห์ หลังจากนั้นปรับเพิ่มขนาดยาเป็น 50 มิลลิกรัมต่อวัน\nกลุ่มอาการรุนแรงก่อนมีประจำเดือน\nผู้ใหญ่รับประทาน 50 มิลลิกรัม วันละ 1 ครั้งของรอบเดือน','04');";
        String Data17 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Amitriptyline','  เป็นยาใช้รักษาอาการจากโรคซึมเศร้า','  ควรทานก่อนนอนและขนาดยาที่ใช้ในการรักษาแตกต่างกันไป\nขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\n    เด็กอายุ 12 ปีขึ้นไปเริ่มต้น 25-50 มิลลิกรัม วันละครั้งก่อนนอน \nหรืออาจแบ่งปริมาณรับประทานมากกว่าวันละหนึ่งครั้ง\n    ผู้ใหญ่เริ่มต้น 50-75 มิลลิกรัม วันละครั้งก่อนนอนหรืออาจแบ่งรับประทานมากกว่าวันละหนึ่งครั้ง\nโดยเพิ่มปริมาณยาขึ้นเรื่อย ๆ ได้ถึง 150 มิลลิกรัม/วัน และใช้ปริมาณสูงสุดไม่เกิน 300 มิลลิกรัม/วัน\n    ผู้สูงอายุ เริ่มต้น 25-50 มิลลิกรัม วันละครั้งก่อนนอน\nหรืออาจแบ่งปริมาณรับประทานมากกว่าวันละหนึ่งครั้ง','03');";
        String Data18 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Nortriptyline','  เป็นยารักษาโรคซึมเศร้าในกลุ่มไตรไซคลิก \nออกฤทธิ์โดยปรับสมดุลสารเคมีในสมองของผู้ป่วยโรคซึมเศร้าให้กลับสู่ภาวะปกติ','  ควรทานเมื่อมีอาการ\n   ผู้ใหญ่ รับประทานวันละ 75-100 มิลลิกรัม โดยแบ่งเป็น 3-4 ครั้ง หากมีอาการรุนแรงอาจเพิ่มปริมาณยาได้แต่ไม่เกินวันละ 150 มิลลิกรัม\n   ผู้สูงอายุและเด็กวัยรุ่น รับประทานวันละ 30-50 มิลลิกรัมโดยแบ่งเป็น 3-4 ครั้ง','04');";
        String Data19 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Furosemide','  ช่วยขับของเหลวส่วนเกินในร่างกายออกมาทางปัสสาวะ\nและช่วยป้องกันร่างกายไม่ให้ดูดซึมเกลือหรือโซเดียมมากจนเกินไป นอกจากนี้ยังใช้ลดอาการบวมน้ำซึ่งเป็นหนึ่งในอาการของภาวะหัวใจวาย โรคตับ โรคไต และโรคไตรั่ว รวมถึงรักษาภาวะความดันโลหิตสูงได้อีกด้วย ยาชนิดนี้เป็นยาที่ต้องใช้ภายใต้คำสั่งของแพทย์เท่านั้น','  ทานได้ทั้งก่อนและหลังอาหารและขนาดยาที่ใช้ในการรักษาแตกต่างกันไป \nขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\nรักษาอาการบวมน้ำเนื่องจากหัวใจวาย\n    ผู้ใหญ่เบื้องต้นรับประทานวันละ 40 มิลลิกรัม \nอาจสามารถลดลงเหลือวันละ 20 มิลลิกรัม หรือ 40 มิลลิกรัม \nวันเว้นวันได้ ตามความรุนแรงของอาการ ในบางกรณีที่ต้องให้ 80 มิลลิกรัมหรือมากกว่านั้น \nอาจต้องแบ่งรับประทานหลายครั้งต่อวัน\n    ผู้สูงอายุเบื้องต้นรับประทาน 20 มิลลิกรัม\nจากนั้นปรับเพิ่มขนาดยาได้หากจำเป็น\nรักษาความดันโลหิตสูง\n    ผู้ใหญ่ 40-80 มิลลิกรัมต่อวัน สามารถให้ควบคู่กับยารักษาความดันโลหิตสูง หรือใช้เพียงชนิดเดียวได้','01');";
        String Data20 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Carbamazepine','  เป็นยาในกลุ่มยากันชัก ออกฤทธิ์โดยลดการนำไฟฟ้าที่ผิดปกติของระบบประสาทและสมองอันเป็นสาเหตุให้เกิดอาการชักและอาการปวด','  ควรทานเมื่อมีอาการและขนาดยาที่ใช้ในการรักษาแตกต่างกันไปขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\n    ผู้ใหญ่เริ่มต้นรับประทานยาขนาด 100-200 มิลลิกรัมวันละ 1 ครั้ง\nหรือแบ่งรับประทานวันละ 2 ครั้ง และค่อยๆเพิ่มขนาดยาทีละน้อยทุกสัปดาห์\nแต่ไม่ควรเกินกว่า 200 มิลลิกรัมต่อวัน \nจากนั้นรับประทานยาแบบต่อเนื่องที่ขนาด 800-1200 มิลลิกรัมสูงสุดไม่ควรเกินวันละ 2 กรัม \n    เด็กรับประทานยาขนาด 10-20 มิลลิกรัมต่อวันต่อน้ำหนักตัว 1 กิโลกรัม','04');";
        String Data21 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Paracetamol','  เป็นยาที่ใช้เพื่อบรรเทาอาการปวดและช่วยลดไข้ โดยนิยมใช้เพื่อรักษาอาการปวดทั่วไป อาการปวดศีรษะ หรือไข้หวัดใหญ่ ทั้งนี้ยังสามารถใช้เพื่อบรรเทาอาการปวดของโรคข้ออักเสบได้อีกด้วยโดยยาชนิดนี้จัดเป็นยาสามัญประจำบ้านเพราะสามารถใช้ได้โดยไม่ต้องมีใบสั่งยาของแพทย์แต่ต้องใช้ในปริมาณที่เหมาะสม','  ควรทานเมื่อมีอาการ\n    เด็ก 10-15 มิลลิกรัม/กิโลกรัม ทุก 4-6 ชั่วโมง (หากจำเป็น)ไม่เกิน 5 ครั้งภายใน 24 ชั่วโมง\n    ผู้ใหญ่ 500 มิลลิกรัม ทุก 4-6 ชั่วโมง ไม่เกิน 4,000 มิลลิกรัม ต่อวัน','04');";
        String Data22 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Sara','  เป็นยาที่ใช้เพื่อบรรเทาอาการปวดและช่วยลดไข้ โดยนิยมใช้เพื่อรักษาอาการปวดทั่วไป อาการปวดศีรษะ หรือไข้หวัดใหญ่ ทั้งนี้ยังสามารถใช้เพื่อบรรเทาอาการปวดของโรคข้ออักเสบได้อีกด้วยโดยยาชนิดนี้จัดเป็นยาสามัญประจำบ้านเพราะสามารถใช้ได้โดยไม่ต้องมีใบสั่งยาของแพทย์แต่ต้องใช้ในปริมาณที่เหมาะสม','  ควรทานเมื่อมีอาการ\n    เด็ก 10-15 มิลลิกรัม/กิโลกรัม ทุก 4-6 ชั่วโมง (หากจำเป็น)ไม่เกิน 5 ครั้งภายใน 24 ชั่วโมง\n    ผู้ใหญ่ 500 มิลลิกรัม ทุก 4-6 ชั่วโมง ไม่เกิน 4,000 มิลลิกรัม ต่อวัน','04');";
        String Data23 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Paracap','  เป็นยาที่ใช้เพื่อบรรเทาอาการปวดและช่วยลดไข้ โดยนิยมใช้เพื่อรักษาอาการปวดทั่วไป อาการปวดศีรษะ หรือไข้หวัดใหญ่ ทั้งนี้ยังสามารถใช้เพื่อบรรเทาอาการปวดของโรคข้ออักเสบได้อีกด้วยโดยยาชนิดนี้จัดเป็นยาสามัญประจำบ้านเพราะสามารถใช้ได้โดยไม่ต้องมีใบสั่งยาของแพทย์แต่ต้องใช้ในปริมาณที่เหมาะสม','  ควรทานเมื่อมีอาการ\n    เด็ก 10-15 มิลลิกรัม/กิโลกรัม ทุก 4-6 ชั่วโมง (หากจำเป็น)ไม่เกิน 5 ครั้งภายใน 24 ชั่วโมง\n    ผู้ใหญ่ 500 มิลลิกรัม ทุก 4-6 ชั่วโมง ไม่เกิน 4,000 มิลลิกรัม ต่อวัน','04');";
        String Data24 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Tylenol','  เป็นยาที่ใช้เพื่อบรรเทาอาการปวดและช่วยลดไข้ โดยนิยมใช้เพื่อรักษาอาการปวดทั่วไป อาการปวดศีรษะ หรือไข้หวัดใหญ่ ทั้งนี้ยังสามารถใช้เพื่อบรรเทาอาการปวดของโรคข้ออักเสบได้อีกด้วยโดยยาชนิดนี้จัดเป็นยาสามัญประจำบ้านเพราะสามารถใช้ได้โดยไม่ต้องมีใบสั่งยาของแพทย์แต่ต้องใช้ในปริมาณที่เหมาะสม','  ควรทานเมื่อมีอาการ\n    เด็ก 10-15 มิลลิกรัม/กิโลกรัม ทุก 4-6 ชั่วโมง (หากจำเป็น)ไม่เกิน 5 ครั้งภายใน 24 ชั่วโมง\n    ผู้ใหญ่ 500 มิลลิกรัม ทุก 4-6 ชั่วโมง ไม่เกิน 4,000 มิลลิกรัม ต่อวัน','04');";
        String Data25 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Decolgen','  บรรเทาหวัด น้ำมูกไหล ปวดศีรษะ และเป็นไข้','  ควรทานเมื่อมีอาการ\n    ผู้ใหญ่รับประทานครั้ง 1-2 เม็ด ทุก 6-8 ชั่วโมง','04');";
        String Data26 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Solmax','  ยาละลายเสมหะเพื่อบรรเทาอาการไอเนื่องจากหลอดลมอักเสบเรื้อรัง หืด หลอดลมและถุงลมพอง จากการไอที่เกิดจากโพรงจมูกอักเสบ','ผ  ู้ใหญ่และเด็กอายุ 12 ปีขึ้นไป ครั้งละ 1 แคปซูลวันละ 3 ครั้ง (หรือตามแพทย์สั่ง)','02');";

        String Data27 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Kremil','  บรรเทาอาการแผลในกระเพาะอาหาร ท้องอืด แน่น จุกเสียด หรือกรดไหลย้อน','  บรรเทาอาการแผลในกระเพาะอาหาร \n    ครั้งละ 2-4 เม็ด ทุก 4 ชั่วโมง หรือตามแพทย์สั่ง\nลดกรด และขับลมในกระเพาะอาหาร \n    ครั้งละ 1-2 เม็ด หลังอาหาร โดยที่เคี้ยว หรือไม่ต้องเคี้ยวก็ได้','02');";
        String Data28 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Tiffy Dey','  บรรเทาอาการคัดจมูก น้ำมูกไหล น้ำตาไหล คันคอ จาม ปวดศีรษะ และเป็นไข้ อันเนื่องมาจากโรคภูมิแพ้ โรคหวัด หรือไข้ละอองฟาง','  ควรทานเมื่อมีอาการ\n    ผู้ใหญ่ ห้รับประทานยาครั้งละ 1-2 เม็ดทุก 4-6 ชั่วโมง \n    เด็กอายุ 6-12 ปีให้รับประทานยาครั้งละ 1 เม็ดทุก 4-6 ชั่วโมง','04');";
        String Data29 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Zyrtec','  มีคุณสมบัติในการรักษาอาการแพ้ต่างๆ บรรเทาอาการคันและอาการที่เกิดจากลมพิษ ช่วยรักษาอาการไข้หวัด ลดน้ำมูก','  ผู้ใหญ่และเด็กอายุ 6 ปีขึ้นไปทานวันละครั้ง\nเด็กอายุ 2-6 ปี ครึ่งเม็ดวันละครั้ง','03');";
        String Data30 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Ponstan','  บรรเทาอาการปวดประจำเดือน และกลุ่มอาการผิดปกติก่อนมีประจำเดือน ลดอาการอักเสบ','  ควรทานเมื่อมีอาการ ไม่ควรรับประทานยาติดต่อกันเกิน 7 วัน ส่วนอาการปวดประจำเดือนโดยปกติแล้วระยะเวลาการรับประทานยาจะอยู่ที่ 2-3 วัน ผู้ใหญ่และผู้ที่มีอายุ 14 ปีขึ้นไปครั้งแรกให้รับประทานยา 500 มิลลิกรัม (2 แคปซูล หรือ 1 เม็ด)ต่อไปให้รับประทานยาครั้งละ 250 มิลลิกรัม โดยให้ซ้ำได้ทุก 6 ชั่วโมงเมื่อมีอาการและสามารถหยุดรับประทานยาได้เมื่อหายจากอาการปวด สำหรับผู้ใหญ่ขนาดสูงสุดที่รับประทานไม่ควรเกิน 500 มิลลิกรัมต่อครั้งและไม่เกิน 3 ครั้งต่อวัน','04');";
        String Data31 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Disento','  ปรับความสมดุลของจุลินทรีย์ในลำไส้ ซึ่งควรรับประทานในปริมาณที่พอเหมาะจะช่วยส่งเสริมสุขภาพของร่างกาย','  ควรทานเมื่อมีอาการ รับประทานครั้งละ 1-2 เม็ด ทุกๆ 4-6 ชั่วโมง หรือตามแพทย์สั่ง','04');";
        String Data32 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('CA-R-BON','  ช่วยดูดซับสารพิษหรือยาบางชนิดจากการรับประทานสารพิษหรือยานั้น ๆ เกินขนาดช่วยรักษาอาการท้องเสียหรือถ่ายเหลวจากภาวะอาหารเป็นพิษ ช่วยแก้อาการท้องอืด ท้องเฟ้อ มีแก๊สในกระเพาะอาหาร','  ควรทานเมื่อมีอาการ','04');";
        String Data33 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Krataibin','  ทำลายเชื้อโรคในลำไส้ รักษาอาการอักเสบของลำไส้ แก้ปวดท้อง แก้ท้องเสีย (อาการท้องเสียจากการติดเชื้อแบบไม่รุนแรง)แก้อาการท้องอืด ท้องเฟ้อ จุกเสียด แน่นท้อง ช่วยขับลมและยังช่วยเคลือบกระเพาะอาหารเพื่อควบคุมเชื้อแบคทีเรียในกระเพาะอาหาร','  ควรทานเมื่อมีอาการหรือหลังอาหาร รับประทานครั้งละ 1-2 ช้อนชา วันละ 3 ครั้งหรือทุก 4-6 ชั่วโมง','04');";
        String Data34 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Circadin','  รักษาอาการนอนไม่หลับ ช่วยปรับสมดุลการนอน โดยการเพิ่มระดับฮอร์โมน Melatonin ส่งเสริมคุณภาพการนอนหลับให้ดีขึ้น','  ควรทาน 2 มิลลิกรัมวันละครั้ง 1-2 ชั่วโมงก่อนนอนและหลังอาหาร (แนะนำให้ทานต่อเนื่องเป็นเวลา 13 สัปดาห์) \nไม่แนะนำ ให้ใช้ยาในผู้ป่วยเด็กหรือวัยรุ่นเนื่องจากข้อมูลด้านความปลอดภัยและประสิทธิผลไม่เพียงพอ','03');";
        String Data35 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Cozaar','  เป็นยาที่ใช้ในการรักษาความดันโลหิตสูง มีสรรพคุณรักษาภาวะความดันโลหิตสูงและโรคหลอดเลือดสมองตีบตัน ออกฤทธิ์โดยทำให้หลอดเลือดเกิดการขยายตัว','  ควรทานเมื่อมีอาการและขนาดยาที่ใช้ในการรักษาแตกต่างกันไป ขึ้นอยู่กับสภาวะโรคที่รักษาและอายุของผู้ป่วย\nความดันโลหิตสูง \n    ผู้ใหญ่ให้ขนาด 50 mg วันละครั้ง และเพิ่มถึง 100 mg แบ่งให้วันละ1-2ครั้ง \n   เด็กอายุมากกว่า 6 ปีให้ขนาด 700 Mcg/Kgเพิ่มจนถึง 50 mg วันละครั้ง \n    ผู้สูงอายุมากกว่า 75 ปีเริ่มต้นให้ 25 วันละครั้ง\nโรคไตเนื่องจากโรคเบาหวาน \n    ผู้ใหญ่ให้ขนาด 50 Mgวันละครั้ง และเพิ่มถึง 100 Mg แบ่งให้วันละ1-2ครั้ง \n    ผู้สูงอายุมากกว่า 75 ปีเริ่มต้นให้ 25 วันละครั้ง \n    ผู้ที่ไตเสื่อมอัตราการกรองน้อยกว่า 20 Ml/Min เริ่มต้นให้วันละ 25 mg','04');";
        String Data36 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Forlax','  ไฟเบอร์สำหรับเพิ่มกากใยอาหาร บรรเทาอาการท้องผูก ช่วยให้ขับถ่ายง่ายขึ้น','ควรทานเมื่อมีอาการท้องผูก','04');";
        String Data37 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Ganaton','  ทำหน้าที่กระตุ้นการเคลื่อนไหวของระบบทางเดินอาหาร โดยเพิ่มการบีบตัวของกระเพาะอาหารและลำไส้','  ควรทานก่อนอาหาร ผู้ใหญ่รับประทานครั้งละ 50 มิลลิกรัมวันละ 3 ครั้ง ทั้งนี้แพทย์สามารถลดขนาดรับประทานลงโดยพิจารณาจากอายุและจากอาการป่วยของผู้ป่วยแต่ละบุคคล ระยะเวลาของการใช้ยานี้อาจยาวนานถึง 8 สัปดาห์ทั้งนี้ขึ้นอยู่กับการตอบสนองของผู้ป่วยและดุลพินิจของแพทย์ผู้รักษา','01');";
        String Data38 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Benda 500','  ยาฆ่าพยาธิ สามารถออกฤทธิ์ฆ่าพยาธิและถ่ายพยาธิได้หลายชนิดภายในเวลาเดียวกัน','  ให้เคี้ยวยาก่อนกลืน รับประทานครั้งละ 1 เม็ด เพียงครั้งเดียว','03');";
        String Data39 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Air-X','  ใช้รักษาอาการท้องอืด ท้องเฟ้อ เนื่องจากแก๊สที่เกิดขึ้นในกระเพาะอาหารและลำไส้ บรรเทาอาการจุกเสียดเนื่องจากแก๊สที่มีปริมาณมากเกินไปและใช้กับผู้ป่วยก่อนทำการตรวจอัลตราซาวนด์ในช่องท้องเพื่อลดแก๊สที่อาจไปบดบังภาพของการตรวจอัลตราซาวนด์','  ควรรับประทานครั้งละ 1-2 เม็ดเคี้ยวเม็ดยาให้ละเอียดก่อนกลืน เมื่อมีอาการท้องอืดท้องเฟ้อ สามารถรับประทานพร้อมอาหารได้','04');";
        String Data40 = "INSERT INTO todo_list (todo_text1,todo_text2,todo_text3,todo_text4) VALUES " +
                "('Siduol','  สำหรับรักษาริดสีดวงทวารทั้งชนิดภายในและภายนอก รวมทั้งรอยแตกของริดสีดวงทวาร ตลอดจนอาการที่เกิดขึ้นร่วมด้วย เช่น มีเลือดออกและการบวมอักเสบ','  ควรทานหลังอาหาร รับประทานครั้งละ 1-2 เม็ด วันละ 3 ครั้ง','02');";




        sqLiteDatabase.execSQL(Data1);
        sqLiteDatabase.execSQL(Data2);
        sqLiteDatabase.execSQL(Data3);
        sqLiteDatabase.execSQL(Data4);
        sqLiteDatabase.execSQL(Data5);
        sqLiteDatabase.execSQL(Data6);
        sqLiteDatabase.execSQL(Data7);
        sqLiteDatabase.execSQL(Data8);
        sqLiteDatabase.execSQL(Data9);
        sqLiteDatabase.execSQL(Data10);
        sqLiteDatabase.execSQL(Data11);
        sqLiteDatabase.execSQL(Data12);
        sqLiteDatabase.execSQL(Data13);
        sqLiteDatabase.execSQL(Data14);
        sqLiteDatabase.execSQL(Data15);
        sqLiteDatabase.execSQL(Data16);
        sqLiteDatabase.execSQL(Data17);
        sqLiteDatabase.execSQL(Data18);
        sqLiteDatabase.execSQL(Data19);
        sqLiteDatabase.execSQL(Data20);
        sqLiteDatabase.execSQL(Data21);
        sqLiteDatabase.execSQL(Data22);
        sqLiteDatabase.execSQL(Data23);
        sqLiteDatabase.execSQL(Data24);
        sqLiteDatabase.execSQL(Data25);
        sqLiteDatabase.execSQL(Data26);
        sqLiteDatabase.execSQL(Data27);
        sqLiteDatabase.execSQL(Data28);
        sqLiteDatabase.execSQL(Data29);
        sqLiteDatabase.execSQL(Data30);
        sqLiteDatabase.execSQL(Data31);
        sqLiteDatabase.execSQL(Data32);
        sqLiteDatabase.execSQL(Data33);
        sqLiteDatabase.execSQL(Data34);
        sqLiteDatabase.execSQL(Data35);
        sqLiteDatabase.execSQL(Data36);
        sqLiteDatabase.execSQL(Data37);
        sqLiteDatabase.execSQL(Data38);
        sqLiteDatabase.execSQL(Data39);
        sqLiteDatabase.execSQL(Data40);

        sqLiteDatabase.execSQL(tableYourMED);
        String xData1 = "INSERT INTO you_med (medname, medinfo) VALUES ('" +
                "Med Text1','แก้ปวดหัว');";
        String xData2 = "INSERT INTO you_med (medname, medinfo) VALUES ('Med Text2','แก้ปวดขา');";
        String xData3 = "INSERT INTO you_med (medname, medinfo) VALUES ('Med Text3','แก้ปวดท้อง');";

        sqLiteDatabase.execSQL(xData1);
        sqLiteDatabase.execSQL(xData2);
        sqLiteDatabase.execSQL(xData3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS you_med");
        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password,String morning,String afternoon,String evening) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        contentValues.put("morning", morning);
        contentValues.put("afternoon", afternoon);
        contentValues.put("evening", evening);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }



    public boolean checkUser(String username, String password) {
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from todo_list ";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
