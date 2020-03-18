package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


import java.io.File;




/**
 * Hello world!
 *
 */
public class CreatIndex
{
    public static void main( String[] args ) throws Exception{
        Directory directory = FSDirectory.open(new File("D:\\index").toPath());
        IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig());
        File searchDir = new File("D:\\360MoveData\\Users\\df\\Desktop\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\87.lucene\\lucene\\02.参考资料\\searchsource");
        File[] searchFiles = searchDir.listFiles();
        for (File searchFile : searchFiles) {
            String fileContent = FileUtils.readFileToString(searchFile, "UTF-8");
            String fileName = searchFile.getName();
            String filePath = searchFile.getPath();
            long fileSize = FileUtils.sizeOf(searchFile);

            Field fieldName = new TextField("name", fileName,Field.Store.YES );
            Field fieldPath = new TextField("path", filePath,Field.Store.YES );
            Field fieldContent = new TextField("content", fileContent,Field.Store.YES );
            Field fieldSize = new TextField("size", fileSize+"",Field.Store.YES );

            Document document = new Document();
            document.add(fieldSize);
            document.add(fieldContent);
            document.add(fieldName);
            document.add(fieldPath);

            indexWriter.addDocument(document);
        }
        indexWriter.close();

        System.out.println( "Hello World!" );
    }
}
