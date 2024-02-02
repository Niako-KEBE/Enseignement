//package com.uasz.enseign.mappers.Repartition;
//import com.uasz.enseign.dto.Repartition.EtudiantDTO;
//import com.uasz.enseign.entities.Repartition.Etudiant;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface EtudiantMapper {
//
//    @Mapping(source = "etudiant.cycle", target = "cycle")
//    @Mapping(source = "etudiant.filiere", target = "filiere")
//    @Mapping(source = "etudiant.niveau", target = "niveau")
//    @Mapping(source = "etudiant.seance", target = "seance")
//    @Mapping(source = "etudiant.enseignant", target = "enseignant")
//    @Mapping(source = "etudiant.semestre", target = "semestre")
//    @Mapping(source = "etudiant.emploiDuTemps", target = "emploiDuTemps")
//    EtudiantDTO etudiantToEtudiantDTO(Etudiant etudiant);
//
//    List<EtudiantDTO> etudiantsToEtudiantDTOs(List<Etudiant> etudiants);
//
//    @Mapping(source = "etudiantDTO.cycle", target = "cycle")
//    @Mapping(source = "etudiantDTO.filiere", target = "filiere")
//    @Mapping(source = "etudiantDTO.niveau", target = "niveau")
//    @Mapping(source = "etudiantDTO.seance", target = "seance")
//    @Mapping(source = "etudiantDTO.enseignant", target = "enseignant")
//    @Mapping(source = "etudiantDTO.semestre", target = "semestre")
//    @Mapping(source = "etudiantDTO.emploiDuTemps", target = "emploiDuTemps")
//    Etudiant etudiantDTOToEtudiant(EtudiantDTO etudiantDTO);
//
//}
