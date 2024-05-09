package testing

import (
	"fmt"
	"reflect"
)

// {fact rule=unsafe-reflection@v1.0 defects=1}
func unsafeReflectionNoncompliant(jobInstance interface{}, userInput string) map[string]interface{} {
	data := make(map[string]interface{})

	jobValue := reflect.ValueOf(jobInstance).Elem()

	// Noncompliant: unsafe user input passed.
	method := jobValue.MethodByName(userInput)

	if method.IsValid() {
		colorValue := method.Call(nil)[0].Interface()
		data["color"] = fmt.Sprintf("%v", colorValue)
	} else {
		colorField := jobValue.FieldByName("color")
		if colorField.IsValid() && colorField.Kind() == reflect.String {
			data["color"] = colorField.String()
		} else {
			data["color"] = "unknown"
		}
	}
	return data
}

// {/fact}

// {fact rule=unsafe-reflection@v1.0 defects=0}
func unsafeReflectionCompliant(jobInstance interface{}) map[string]interface{} {
	data := make(map[string]interface{})

	jobValue := reflect.ValueOf(jobInstance).Elem()

	// Compliant: Constant input passed.
	method := jobValue.MethodByName("name")

	if method.IsValid() {
		colorValue := method.Call(nil)[0].Interface()
		data["color"] = fmt.Sprintf("%v", colorValue)
	} else {
		colorField := jobValue.FieldByName("color")
		if colorField.IsValid() && colorField.Kind() == reflect.String {
			data["color"] = colorField.String()
		} else {
			data["color"] = "unknown"
		}
	}
	return data
}

// {/fact}
