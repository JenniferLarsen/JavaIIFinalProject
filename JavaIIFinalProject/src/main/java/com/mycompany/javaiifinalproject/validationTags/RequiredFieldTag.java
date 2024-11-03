/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author djlar
 */
package com.mycompany.javaiifinalproject.validationTags; 

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class RequiredFieldTag extends SimpleTagSupport {

    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.write(label);
            out.write("*");
        } catch (java.io.IOException e) {
            throw new JspException(e.getMessage());
        }
    }
}