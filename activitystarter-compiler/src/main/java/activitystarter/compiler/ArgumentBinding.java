package activitystarter.compiler;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import javax.lang.model.type.TypeMirror;

final class ArgumentBinding {
    private final String name;
    private final TypeName type;
    private final TypeMirror elementType;
    private final boolean required;

    ArgumentBinding(String name, TypeName type, TypeMirror elementType, boolean required) {
        this.name = name;
        this.type = type;
        this.elementType = elementType;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public TypeName getType() {
        return type;
    }

    ClassName getRawType() {
        if (type instanceof ParameterizedTypeName)
            return ((ParameterizedTypeName) type).rawType;

        if (type instanceof ClassName)
            return (ClassName) type;

        return null;
    }

    public boolean isRequired() {
        return required;
    }

    public TypeMirror getElementType() {
        return elementType;
    }
}
