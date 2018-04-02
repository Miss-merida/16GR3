package com.qhit.lh.gr3.merida.exam.tkgl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qhit.lh.gr3.merida.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.merida.exam.tkgl.bean.WrittenQuestion;

public class PoiReaderExcel {

	@SuppressWarnings("resource")
	public static List<WrittenQuestion> readerExcel(InputStream is,Course course) {
		List<WrittenQuestion> listQuestion = new ArrayList<WrittenQuestion>();
		//�������򿪹�����
		Workbook workbook = null;
		try{
			//��ȡ�������е��ļ�����
			workbook = new HSSFWorkbook(is);
		}catch(Exception e){
			try {
				//��ȡ�������е��ļ�����
				workbook = new XSSFWorkbook(is);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			//��ȡĬ�ϵĵ�һ��������
			Sheet sheet = (Sheet) workbook.getSheetAt(0);
			//������Ϊ1���п�ʼ��
			int firstRowIndex = 1;
			//���������ݵ�����е�����
			int lastRowIndex = sheet.getPhysicalNumberOfRows();
			for (int i = firstRowIndex; i < lastRowIndex; i++) {
				//ͨ��������ȡ��ǰ�еĶ���
				Row row = sheet.getRow(i);
				WrittenQuestion question = new WrittenQuestion();
				//��ȡ���Ԫ������
				int lastCellIndex = row.getLastCellNum();
				if(row.getCell(0).getStringCellValue() == null && "".equals(row.getCell(0).getStringCellValue())){
					break;
				}
				for (int j = 0; j < lastCellIndex; j++) {
					//��ȡ��ǰ��Ԫ��Ķ���
					Cell cell = row.getCell(j);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					switch (j) {
					case 0:
						question.setQtitle(cell.getStringCellValue());
						break;
					case 1:
						question.setOptionA(cell.getStringCellValue());
						break;
					case 2:
						question.setOptionB(cell.getStringCellValue());
						break;
					case 3:
						question.setOptionC(cell.getStringCellValue());
						break;
					case 4:
						question.setOptionD(cell.getStringCellValue());
						break;
					case 5:
						question.setAnswer(cell.getStringCellValue());
						break;
					case 6:
						question.setQtype(cell.getStringCellValue());
						break;
					case 7:
						question.setDegree(cell.getStringCellValue());
						break;
					case 8:
						question.setChapter(cell.getStringCellValue());
						break;
					}
				}
				//���ÿγ̱��
				question.setCsId(course.getCsId());
				//�������Ϳγ̵Ĺ�ϵ
				question.setCourse(course);
				//�Ѷ�ȡ��������󱣴浽������
				listQuestion.add(question);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listQuestion;
	}

}
