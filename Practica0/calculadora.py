def main():
    numeros = []
    
    
    
    print("Ingresa una serie de números uno por uno (ingresa -1 para terminar):")

    while True:
        numero = float(input("Ingresa un número: "))
        if numero == -1:
            break  # Termina la entrada si el usuario ingresa -1
        numeros.append(numero)  # Agregar el número a la lista

    # Verificar si se ingresaron números
    if len(numeros) > 0:
        total_numeros = len(numeros)
        suma = sum(numeros)
        promedio = suma / total_numeros
        numero_mayor = max(numeros)
        numero_menor = min(numeros)

        # Mostrar las estadísticas
        print("\nEstadísticas:")
        print(f"Total de números ingresados: {total_numeros}")
        print(f"Suma de los números: {suma}")
        print(f"Promedio de los números: {promedio}")
        print(f"Número más grande: {numero_mayor}")
        print(f"Número más pequeño: {numero_menor}")
    else:
        print("No se ingresaron números.")


if __name__ == "__main__":
    main()
