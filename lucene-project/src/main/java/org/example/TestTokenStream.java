package org.example;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/13 18:35
 */
public class TestTokenStream {
    public static void main(String[] args) throws Exception{
        Analyzer analyzer = new IKAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream("", "最佳答案: 皇城PK,胜者为王。 屠龙宝刀,点击就送。 极品装备,一秒刷爆。 幸运抽奖,惊喜不断。 经典装备,极品属性。 神秘宝箱,开箱有喜。");
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        tokenStream.close();
    }
}
