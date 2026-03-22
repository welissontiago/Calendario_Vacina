package com.hackaton.grupo1.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hackaton.grupo1.demo.dto.ImunizacaoDTO;
import com.hackaton.grupo1.demo.entity.Dose;
import com.hackaton.grupo1.demo.entity.Paciente;
import com.hackaton.grupo1.demo.exceptions.BadRequestException;
import com.hackaton.grupo1.demo.exceptions.ResourceNotFoundException;
import com.hackaton.grupo1.demo.repository.DoseRepository;
import com.hackaton.grupo1.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.grupo1.demo.entity.Imunizacao;
import com.hackaton.grupo1.demo.repository.ImunizacaoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImunizacaoService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoseRepository doseRepository;

    @Autowired
    private ImunizacaoRepository imunizacaoRepository;

    public Imunizacao salvar(ImunizacaoDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado."));

        Dose dose = doseRepository.findById(dto.getIdDose())
                .orElseThrow(() -> new ResourceNotFoundException("Dose não encontrada."));

        if (imunizacaoRepository.existsByPaciente_IdAndDose_Id(dto.getIdPaciente(), dto.getIdDose())) {
            throw new BadRequestException("O paciente já possui registro para esta dose específica.");
        }

        if (dto.getDataAplicacao() != null) {
            if (dto.getDataAplicacao().isAfter(LocalDate.now())) {
                throw new BadRequestException("A data de aplicação da vacina não pode ser no futuro.");
            }
            if (dto.getDataAplicacao().isBefore(paciente.getData_nascimento())) {
                throw new BadRequestException("A data de aplicação não pode ser anterior à data de nascimento do paciente.");
            }
        }



        Imunizacao imunizacao = new Imunizacao();
        imunizacao.setDataAplicacao(dto.getDataAplicacao());
        imunizacao.setFabricante(dto.getFabricante());
        imunizacao.setLote(dto.getLote());
        imunizacao.setLocalAplicacao(dto.getLocalAplicacao());
        imunizacao.setProfissionalAplicador(dto.getProfissionalAplicador());
        imunizacao.setPaciente(paciente);
        imunizacao.setDose(dose);

        return imunizacaoRepository.save(imunizacao);
    }

    public Imunizacao alterar(Integer id, ImunizacaoDTO dto) {
        Imunizacao imunizacao = imunizacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Imunização não encontrada."));

        if (dto.getIdPaciente() != null) {
            Paciente paciente = pacienteRepository.findById(dto.getIdPaciente())
                    .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado."));
            imunizacao.setPaciente(paciente);
        }

        if (dto.getIdDose() != null) {
            Dose dose = doseRepository.findById(dto.getIdDose())
                    .orElseThrow(() -> new ResourceNotFoundException("Dose não encontrada."));
            imunizacao.setDose(dose);
        }

        if (dto.getDataAplicacao() != null) {
            if (dto.getDataAplicacao().isAfter(LocalDate.now())) {
                throw new BadRequestException("A data não pode ser no futuro.");
            }
            if (imunizacao.getPaciente() != null &&
                    dto.getDataAplicacao().isBefore(imunizacao.getPaciente().getData_nascimento())) {
                throw new BadRequestException("Data anterior ao nascimento do paciente.");
            }

            imunizacao.setDataAplicacao(dto.getDataAplicacao());
        }

        if (dto.getFabricante() != null) imunizacao.setFabricante(dto.getFabricante());
        if (dto.getLote() != null) imunizacao.setLote(dto.getLote());
        if (dto.getLocalAplicacao() != null) imunizacao.setLocalAplicacao(dto.getLocalAplicacao());
        if (dto.getProfissionalAplicador() != null) imunizacao.setProfissionalAplicador(dto.getProfissionalAplicador());

        return imunizacaoRepository.save(imunizacao);
    }

    public void excluir(Integer id) {
        if (!imunizacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Imunização não encontrada.");
        }
        imunizacaoRepository.deleteById(id);
    }

    @Transactional
    public void excluirPorPaciente(Integer idPaciente) {
        if (!pacienteRepository.existsById(idPaciente)) {
            throw new ResourceNotFoundException("Paciente não encontrado.");
        }
        imunizacaoRepository.deleteByPaciente_Id(idPaciente);
    }

    public List<Imunizacao> consultarTodas() {
        return imunizacaoRepository.findAll();
    }

    public Optional<Imunizacao> consultarPorId(Integer id) {
        return imunizacaoRepository.findById(id);
    }

    public List<Imunizacao> consultarPorPaciente(Integer idPaciente) {
        if (!pacienteRepository.existsById(idPaciente)) {
            throw new ResourceNotFoundException("Paciente não encontrado.");
        }
        return imunizacaoRepository.findByPaciente_Id(idPaciente);
    }

    public List<Imunizacao> consultarPorPacienteEPeriodo(Integer idPaciente,
                                                         LocalDate dataInicio,
                                                         LocalDate dataFim) {
        if (!pacienteRepository.existsById(idPaciente)) {
            throw new ResourceNotFoundException("Paciente não encontrado.");
        }
        return imunizacaoRepository.findByPaciente_IdAndDataAplicacaoBetween(
                idPaciente, dataInicio, dataFim);
    }
}