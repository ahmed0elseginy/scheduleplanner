package com.ru.spbstu.util;

import com.ru.spbstu.entities.SemesterPreference;
import com.ru.spbstu.entities.SessionPreference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ExcelExporter {

    public static InputStream exportSemesterPreferences(List<SemesterPreference> prefs) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Semester Preferences");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Преподаватель");
            header.createCell(1).setCellValue("Предмет");
            header.createCell(2).setCellValue("Нагрузка");
            header.createCell(3).setCellValue("Комментарий");

            int rowNum = 1;
            for (SemesterPreference p : prefs) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(p.getUser().getFullName());
                row.createCell(1).setCellValue(p.getSubjectName());
                row.createCell(2).setCellValue(p.getLoadType());
                row.createCell(3).setCellValue(p.getComments());
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при экспорте Excel", e);
        }
    }

    public static InputStream exportSessionPreferences(List<SessionPreference> prefs) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Session Preferences");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Преподаватель");
            header.createCell(1).setCellValue("Предмет");
            header.createCell(2).setCellValue("Даты");
            header.createCell(3).setCellValue("Комментарий");

            int rowNum = 1;
            for (SessionPreference p : prefs) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(p.getUser().getFullName());
                row.createCell(1).setCellValue(p.getSubjectName());
                row.createCell(2).setCellValue((Date) p.getPreferredDates());
                row.createCell(3).setCellValue(p.getComments());
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при экспорте Excel", e);
        }
    }
}
