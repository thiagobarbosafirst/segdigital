'use strict'

angular.module('sistemaApp.services', []).factory('sistemaService',
		[ "$http", function($http) {
			var service = {};
			service.getSistemasByDescricao = function(sistemaDescricao) {
				var url = "/sistema/getSistemas/"+ sistemaDescricao;
				return $http.get(url);
			}
			service.getAllSistemas = function() {
				return $http.get("/sistema/getAllSistemas");
			}
			service.saveSistema = function(sistemaDto) {
				return $http.post("/sistema/saveSistema", sistemaDto);
			}
			return service;
		}]);