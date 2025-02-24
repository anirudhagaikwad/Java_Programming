package oop;
/*
# Access Modifiers in Java

Access modifiers in Java define the visibility and accessibility of classes, variables, methods, and constructors. 
Java provides four access modifiers to control the scope of class members.

---
## Access Modifiers Table

| Modifier    | Class  | Package | Subclass(Outside Package) | Project |
|-------------|--------|---------|---------------------------|---------|
| private     | ✅ Yes | ❌ No   | ❌ No                     | ❌ No   |
| default     | ✅ Yes | ✅ Yes  | ❌ No                     | ❌ No   |
| protected   | ✅ Yes | ✅ Yes  | ✅ Yes (only in subclass) | ❌ No   |
| public      | ✅ Yes | ✅ Yes  | ✅ Yes                    | ✅ Yes  |

---
## Description of Access Modifiers
1. private  
   - The most restrictive modifier.
   - Members marked as `private` are only accessible within the same class.
   - Not accessible in the same package, subclasses, or other parts of the project.

2. default (no modifier)  
   - When no access modifier is specified, it is considered package-private.
   - The member is accessible only within the same package.
   - Cannot be accessed outside the package, even in subclasses.

3. protected  
   - Allows access within the same package and in subclasses outside the package.
   - Useful for inheritance when we want to share functionality while restricting access to the outside world.

4. public  
   - The least restrictive modifier.
   - Members marked as `public` can be accessed from anywhere in the project.

---

## Key Points
- Use `private` for data hiding (Encapsulation) to protect sensitive information.
- Use `default` for package-level access when the functionality should be limited to a specific package.
- Use `protected` in inheritance when subclasses should have access to certain members.
- Use `public` for global access when a member should be accessible from anywhere.


*/
public class P16_AccessModifier {

	public static void main(String[] args) {
		

	}

}
