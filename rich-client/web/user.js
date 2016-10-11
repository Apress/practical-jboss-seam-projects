Seam.Remoting.type.org$jimfarley$users$Role = function() {
  this.description = undefined;
  this.name = undefined;
  this.id = undefined;
  Seam.Remoting.type.org$jimfarley$users$Role.prototype.getDescription = function() { return this.description; }
  Seam.Remoting.type.org$jimfarley$users$Role.prototype.getName = function() { return this.name; }
  Seam.Remoting.type.org$jimfarley$users$Role.prototype.getId = function() { return this.id; }
  Seam.Remoting.type.org$jimfarley$users$Role.prototype.setDescription = function(description) { this.description = description; }
  Seam.Remoting.type.org$jimfarley$users$Role.prototype.setName = function(name) { this.name = name; }
  Seam.Remoting.type.org$jimfarley$users$Role.prototype.setId = function(id) { this.id = id; }
}

Seam.Remoting.type.org$jimfarley$users$Role.__name = "org.jimfarley.users.Role";
Seam.Remoting.type.org$jimfarley$users$Role.__metadata = [
  {field: "description", type: "str"},
  {field: "name", type: "str"},
  {field: "id", type: "number"}];

Seam.Remoting.registerType(Seam.Remoting.type.org$jimfarley$users$Role);

Seam.Remoting.type.user = function() {
  this.password = undefined;
  this.login = undefined;
  this.email = undefined;
  this.roles = undefined;
  this.name = undefined;
  this.id = undefined;
  Seam.Remoting.type.user.prototype.getPassword = function() { return this.password; }
  Seam.Remoting.type.user.prototype.getLogin = function() { return this.login; }
  Seam.Remoting.type.user.prototype.getEmail = function() { return this.email; }
  Seam.Remoting.type.user.prototype.getRoles = function() { return this.roles; }
  Seam.Remoting.type.user.prototype.getName = function() { return this.name; }
  Seam.Remoting.type.user.prototype.getId = function() { return this.id; }
  Seam.Remoting.type.user.prototype.setPassword = function(password) { this.password = password; }
  Seam.Remoting.type.user.prototype.setLogin = function(login) { this.login = login; }
  Seam.Remoting.type.user.prototype.setEmail = function(email) { this.email = email; }
  Seam.Remoting.type.user.prototype.setRoles = function(roles) { this.roles = roles; }
  Seam.Remoting.type.user.prototype.setName = function(name) { this.name = name; }
  Seam.Remoting.type.user.prototype.setId = function(id) { this.id = id; }
}

Seam.Remoting.type.user.__name = "user";
Seam.Remoting.type.user.__metadata = [
  {field: "password", type: "str"},
  {field: "login", type: "str"},
  {field: "email", type: "str"},
  {field: "roles", type: "bag"},
  {field: "name", type: "str"},
  {field: "id", type: "number"}];

Seam.Component.register(Seam.Remoting.type.user);

