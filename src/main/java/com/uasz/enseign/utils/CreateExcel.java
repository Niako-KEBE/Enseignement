//package com.uasz.enseign.utils;
//
//import com.uasz.enseign.entities.Maquette.User;
//import com.uasz.enseign.entities.Repartition.Etudiant;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//public class CreateExcel {
//
//    public static void createUtilisateurExcel(List<User> utilisateurs, String filePath) throws IOException {
//        try (Workbook workbook = new XSSFWorkbook()) {
//            Sheet sheet = workbook.createSheet("Gérer les Utilisateurs");
//
//            // Créer la première ligne (header)
//            Row headerRow = sheet.createRow(0);
//            String[] headers = {"Nom", "Prénom", "Email", "Adresse", "Cycle", "Filière", "Niveau", "Type"};
//            for (int i = 0; i < headers.length; i++) {
//                Cell cell = headerRow.createCell(i);
//                cell.setCellValue(headers[i]);
//            }
//
//            // Remplir les données
//            int rowNum = 1;
//            for (User utilisateur : utilisateurs) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(utilisateur.getNom());
//                row.createCell(1).setCellValue(utilisateur.getPrenom());
//                row.createCell(2).setCellValue(utilisateur.getEmail());
//                row.createCell(3).setCellValue(utilisateur.getMatricule());
//
//                if (User instanceof Etudiant) {
//                    // Pour les étudiants, ajoutez les informations spécifiques
//                    Etudiant etudiant = (Etudiant) User;
//                    row.createCell(4).setCellValue(etudiant.getCycle().getLibelle());
//                    row.createCell(5).setCellValue(etudiant.getFiliere().getLibelle());
//                    row.createCell(6).setCellValue(etudiant.getNiveau().getLibelle());
//                    row.createCell(7).setCellValue("Etudiant");
//                } else {
//                    // Ajoutez des conditions similaires pour d'autres types d'utilisateurs
//                    // (enseignant, responsable pédagogique, responsable administratif, etc.)
//                }
//            }
//
//            // Enregistrez le fichier Excel
//            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
//                workbook.write(fileOut);
//            }
//        }
//    }
//}
