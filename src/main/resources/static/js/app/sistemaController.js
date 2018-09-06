'use strict'

var module = angular.module('sistemaApp.controllers', []);
module.controller("sistemaController", ["$scope", "$timeout", "sistemaService",
		function($scope, $timeout, sistemaService) {			
			
			$scope.inicio = function() {
				$scope.isCadastro = false;
				$scope.tipoTela = "Pesquisar";
				$scope.resultSistemas = null;
				$scope.mensagemBool = false;
				$scope.mensagem = "";
				$scope.tipoAlerta = "alert-danger"
				$scope.sistemaDto = {
						id : null,
						descricao : '',
						sigla : '',
						email : '',
						url : ''
					};
			}
			
			$scope.chamarCadastro = function() {
				$scope.isCadastro = true;
				$scope.tipoTela = "Cadastrar";
				$scope.limparCampos();
			};
			
			$scope.telaPesquisa = function() {
				$scope.isCadastro = false;
				$scope.tipoTela = "Pesquisar";
				$scope.getAllSistemas();
				$scope.limparCampos();
			};
			
			$scope.getAllSistemas = function() {
				sistemaService.getAllSistemas().then(function(value) {
					$scope.resultSistemas = value.data;
				}, function(reason) {
					console.log("ocorreu um erro");
				}, function(value) {
					console.log("Não houve callback");
				});
			}
			
			$scope.getAllSistemas();
			
			$scope.limparCampos = function() {
				$scope.sistemaDto = {
						id : null,
						descricao : '',
						sigla : '',
						email : '',
						url : '',
						status : 'ATIVO'
					};
			}
			
			$scope.saveSistema = function() {
				sistemaService.saveSistema($scope.sistemaDto).then(function() {
					$scope.sistemaDto = {
							id : null,
							descricao : '',
							sigla : '',
							email : '',
							url : '',
							status : 'ATIVO'
					};
					$scope.mensagemBool = true;
					$scope.mensagem = "Sistema salvo com sucesso";
					$scope.tipoAlerta = "alert-success";
					
					$timeout(function(){
						console.log("passou no timeout");
						$scope.mensagemBool = false;
						$scope.mensagem = "";
						$scope.tipoAlerta = "";
					}, 3000 );
					$scope.getAllSistemas();
				}, function(reason) {
					$scope.mensagemBool = true;
					$scope.mensagem = "Erro: o sistema não foi salvo ";
					$scope.tipoAlerta = "alert-danger";
					
					$timeout(function(){
						$scope.mensagemBool = false;
						$scope.mensagem = "";
						$scope.tipoAlerta = "";
					}, 3000 );
				}, function(value) {
					console.log("Não houve callback");
				});
			}
			
			$scope.pesquisarSistema = function() {
				sistemaService.getSistemasByDescricao($scope.sistemaDto.descricao).then(function(value) {
					console.log("pesquisando");					
					$scope.resultSistemas = value.data;
				}, function(reason) {
					console.log("Ocorreu um erro");
				}, function(value) {
					console.log("Não houve callback");
				});
			}			
		}
	]);