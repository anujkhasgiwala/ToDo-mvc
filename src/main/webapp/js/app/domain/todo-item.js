define([
  "backbone"
], function(Backbone) {
  "use strict";

  return Backbone.Model.extend({
  	toggle: function () {
  	  return this.set("completed", !this.isCompleted());
  	},
  	isCompleted: function () {
        return this.get("completed");
  	},
  	matchesFilter: function (filter) {
      if (filter === "all") {
        return true;
  	  }

      if (filter === "active") {
        return !this.isCompleted();
      }

      return this.isCompleted();
  	}
  });
  
  return Backbone.Collection.extend({
	  model: TodoItem,
	  url: "/api/todo-items/delete/",
	  getCompleted: function () {
		  return this.filter(this._isCompleted);
	  },
	  getActive: function () {
		  return this.reject(this._isCompleted);
	  },
	  _isCompleted: function (todo) {
		  return todo.isCompleted();
	  }
  });
});