/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine.BackEnd;

import java.util.Date;

/**
 *
 * @author Voranipit
 */
public class Comment extends Person{
    private String statement;
    private String writer;
    Date date;

    public Comment() {
    }

    public Comment(String statement, String writer) {
        this.statement = statement;
        this.writer = writer;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    @Override
    public String toString() {
        return "Comment{" + "statement: " + statement + ", writer: " + writer + '}';
    }
    
    
}
