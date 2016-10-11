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

Seam.Remoting.type.org$jimfarley$gadgets$StatusCode = function() {
  this.code = undefined;
  this.description = undefined;
  Seam.Remoting.type.org$jimfarley$gadgets$StatusCode.prototype.getCode = function() { return this.code; }
  Seam.Remoting.type.org$jimfarley$gadgets$StatusCode.prototype.getDescription = function() { return this.description; }
  Seam.Remoting.type.org$jimfarley$gadgets$StatusCode.prototype.setCode = function(code) { this.code = code; }
  Seam.Remoting.type.org$jimfarley$gadgets$StatusCode.prototype.setDescription = function(description) { this.description = description; }
}

Seam.Remoting.type.org$jimfarley$gadgets$StatusCode.__name = "org.jimfarley.gadgets.StatusCode";
Seam.Remoting.type.org$jimfarley$gadgets$StatusCode.__metadata = [
  {field: "code", type: "number"},
  {field: "description", type: "str"}];

Seam.Remoting.registerType(Seam.Remoting.type.org$jimfarley$gadgets$StatusCode);

Seam.Remoting.type.gadgetType = function() {
  this.label = undefined;
  this.submitter = undefined;
  this.description = undefined;
  this.status = undefined;
  this.id = undefined;
  Seam.Remoting.type.gadgetType.prototype.getLabel = function() { return this.label; }
  Seam.Remoting.type.gadgetType.prototype.getSubmitter = function() { return this.submitter; }
  Seam.Remoting.type.gadgetType.prototype.getDescription = function() { return this.description; }
  Seam.Remoting.type.gadgetType.prototype.getStatus = function() { return this.status; }
  Seam.Remoting.type.gadgetType.prototype.getId = function() { return this.id; }
  Seam.Remoting.type.gadgetType.prototype.setLabel = function(label) { this.label = label; }
  Seam.Remoting.type.gadgetType.prototype.setSubmitter = function(submitter) { this.submitter = submitter; }
  Seam.Remoting.type.gadgetType.prototype.setDescription = function(description) { this.description = description; }
  Seam.Remoting.type.gadgetType.prototype.setStatus = function(status) { this.status = status; }
  Seam.Remoting.type.gadgetType.prototype.setId = function(id) { this.id = id; }
}

Seam.Remoting.type.gadgetType.__name = "gadgetType";
Seam.Remoting.type.gadgetType.__metadata = [
  {field: "label", type: "str"},
  {field: "submitter", type: "bean"},
  {field: "description", type: "str"},
  {field: "status", type: "bean"},
  {field: "id", type: "number"}];

Seam.Component.register(Seam.Remoting.type.gadgetType);

Seam.Remoting.type.gadgetFeature = function() {
  this.label = undefined;
  this.submitter = undefined;
  this.description = undefined;
  this.status = undefined;
  this.id = undefined;
  Seam.Remoting.type.gadgetFeature.prototype.getLabel = function() { return this.label; }
  Seam.Remoting.type.gadgetFeature.prototype.getSubmitter = function() { return this.submitter; }
  Seam.Remoting.type.gadgetFeature.prototype.getDescription = function() { return this.description; }
  Seam.Remoting.type.gadgetFeature.prototype.getStatus = function() { return this.status; }
  Seam.Remoting.type.gadgetFeature.prototype.getId = function() { return this.id; }
  Seam.Remoting.type.gadgetFeature.prototype.setLabel = function(label) { this.label = label; }
  Seam.Remoting.type.gadgetFeature.prototype.setSubmitter = function(submitter) { this.submitter = submitter; }
  Seam.Remoting.type.gadgetFeature.prototype.setDescription = function(description) { this.description = description; }
  Seam.Remoting.type.gadgetFeature.prototype.setStatus = function(status) { this.status = status; }
  Seam.Remoting.type.gadgetFeature.prototype.setId = function(id) { this.id = id; }
}

Seam.Remoting.type.gadgetFeature.__name = "gadgetFeature";
Seam.Remoting.type.gadgetFeature.__metadata = [
  {field: "label", type: "str"},
  {field: "submitter", type: "bean"},
  {field: "description", type: "str"},
  {field: "status", type: "bean"},
  {field: "id", type: "number"}];

Seam.Component.register(Seam.Remoting.type.gadgetFeature);

Seam.Remoting.type.gadget = function() {
  this.types = undefined;
  this.submitter = undefined;
  this.features = undefined;
  this.description = undefined;
  this.status = undefined;
  this.name = undefined;
  this.id = undefined;
  Seam.Remoting.type.gadget.prototype.getTypes = function() { return this.types; }
  Seam.Remoting.type.gadget.prototype.getSubmitter = function() { return this.submitter; }
  Seam.Remoting.type.gadget.prototype.getFeatures = function() { return this.features; }
  Seam.Remoting.type.gadget.prototype.getDescription = function() { return this.description; }
  Seam.Remoting.type.gadget.prototype.getStatus = function() { return this.status; }
  Seam.Remoting.type.gadget.prototype.getName = function() { return this.name; }
  Seam.Remoting.type.gadget.prototype.getId = function() { return this.id; }
  Seam.Remoting.type.gadget.prototype.setTypes = function(types) { this.types = types; }
  Seam.Remoting.type.gadget.prototype.setSubmitter = function(submitter) { this.submitter = submitter; }
  Seam.Remoting.type.gadget.prototype.setFeatures = function(features) { this.features = features; }
  Seam.Remoting.type.gadget.prototype.setDescription = function(description) { this.description = description; }
  Seam.Remoting.type.gadget.prototype.setStatus = function(status) { this.status = status; }
  Seam.Remoting.type.gadget.prototype.setName = function(name) { this.name = name; }
  Seam.Remoting.type.gadget.prototype.setId = function(id) { this.id = id; }
}

Seam.Remoting.type.gadget.__name = "gadget";
Seam.Remoting.type.gadget.__metadata = [
  {field: "types", type: "bag"},
  {field: "features", type: "bag"},
  {field: "submitter", type: "bean"},
  {field: "description", type: "str"},
  {field: "status", type: "bean"},
  {field: "name", type: "str"},
  {field: "id", type: "number"}];

Seam.Component.register(Seam.Remoting.type.gadget);

