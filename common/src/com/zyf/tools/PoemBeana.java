/**
 * 沈阳卓越科技有限公司版权所有
 * 制作时间：Oct 29, 20079:55:21 AM
 * 文件名：PoemBeana.java
 * 制作者：zhaoyf
 * 
 */
package com.zyf.tools;

/**
 * @author zhaoyf
 *
 */
import java.util.ArrayList;
import java.util.List;

public class PoemBeana {

    private List lines = new ArrayList();
    
    public List getLines() {
        return lines;
    }
    
    public void addLine(String line) {
        lines.add(line);
    }
}

