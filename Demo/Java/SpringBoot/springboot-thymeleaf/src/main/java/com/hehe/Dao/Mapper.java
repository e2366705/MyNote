package com.hehe.Dao;

import com.hehe.POJO.Words_Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Select("SELECT * FROM words_warehouse")
    @Results({
        @Result(property = "word",  column = "word"),
        @Result(property = "chinese_meaning", column = "chinese_meaning"),
        @Result(property = "level", column = "level")
    })
    List<Words_Warehouse> getAll();



    @Select("SELECT * FROM words_warehouse WHERE word = #{word}")
    @Results({
        @Result(property = "word",  column = "word"),
        @Result(property = "chinese_meaning", column = "chinese_meaning"),
    })
    Words_Warehouse getOne(String word);


    @Select("SELECT `chinese_meaning` FROM `words_warehouse` where `word` = #{word}")
    @Results({
            @Result(property = "word",  column = "word"),
            @Result(property = "chinese_meaning", column = "chinese_meaning"),
    })
    Words_Warehouse Find_chinese_mean_MYSQL(String word);



    @Select("select count(*) from `words_warehouse` where length(`word`) = #{word}")
    int Get_words_length(String word);



    //  select * from `words_warehouse` where length(`word`) = 12 limit 0,3;
    @Select("<script> select * from words_warehouse"
            + " <where>"
            + "     <if test='words_length != null' > "
            + "	        length(`word`)  = #{words_length}"
            + "	    </if>"
            + "</where>"
            + "limit  #{index_start} , 1;"
            + "</script>")
    List<Words_Warehouse> Get_one_word(String words_length , int index_start);





    @Insert("INSERT INTO words_warehouse(words_warehousename) VALUES(#{words_warehouseName})")
    void insert(Words_Warehouse words_warehouse);

    @Update("UPDATE words_warehouse SET words_warehouseName=#{words_warehouseName} WHERE word =#{word}")
    void update(Words_Warehouse words_warehouse);

    @Delete("DELETE FROM words_warehouse WHERE word =#{word}")
    void delete(Integer word);

}
