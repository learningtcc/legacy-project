package com.zyf.common.transfer.importexcel;

import java.io.InputStream;

/**
 * ��д<code>dbf</code>,<code>excel</code>�ļ������, ���������ж������ݲ�����
 * {@link CommonTransferService#writeRow(java.util.Map, HrTransferConfigItem[]) writeRow}
 * ����. ����ӿڵ�ʵ�ֲ���Ҫ�����쳣
 * @author Scott Captain
 * @since 2006-8-17
 * @version $Id: CommonTransfer.java,v 1.2 2007/12/17 11:02:39 lanxg Exp $
 *
 */
public interface CommonTransfer {
    
    /**
     * �����������ʹ���߼���ʵ����, ����һ��<code>excel</code>��ʵ�ֵ�����Ӧ����:<code>
     * hr.excel.hrTransfer</code>, ʹ����(HrTransferServicde)��ʹ��������Ʋ���ʵ����
     */
    String SERVICE_NAME = "commonTransfer";
    
    /**
     * ������������<code>dbf</code>, <code>excel</code>�ȸ�ʽ������, ÿ��һ�ж�����
     * {@link CommonTransferService#writeRow(java.util.Map) writeRow}
     * ����
     * @param in        ����Ҫ�������ݵ�������
     * @param serivce   �ص������ķ���
     * @return          ���뵽���ݿ������
     */
    int transfer(InputStream in, CommonTransferCallback callback) throws Exception;
}