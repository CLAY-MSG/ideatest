package org.example;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/13 16:59
 */
public class SearchIndex {
    public static void main(String[] args) throws Exception{
        Directory directory = FSDirectory.open(new File("D:\\index").toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Query query = new TermQuery(new Term("content", "spring"));
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("总记录数："+topDocs.totalHits);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            String name = document.get("name");
            String size = document.get("size");
            String path = document.get("path");

            System.out.println("name"+name+"---size"+size+"---path"+path);
        }

        indexReader.close();

    }
}
