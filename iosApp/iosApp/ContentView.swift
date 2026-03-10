import SwiftUI
import Shared

struct ContentView: View {
    @State private var showContent = false
    @State private var size: CGSize = .zero
    var body: some View {
        VStack {
            Button("Click me!") {
                withAnimation {
                    showContent = !showContent
                }
            }
            //Text("SwiftUI: \(Greeting().greet()) ")
            if showContent {
                HStack(spacing: 16) {
                    Text("Width: \(size.width)")
                    Image(systemName: "swift")
                        .font(.system(size: 100))
                        .foregroundColor(.accentColor)
                    //Spacer() // Pushes the header to the top and the footer to the bottom
                    //Text("SwiftUI: \(Greeting().greet()) ")
                    Text(" Height: \(size.height)")
                }
                .transition(.move(edge: .top).combined(with: .opacity))
                .onGeometryChange(for: CGSize.self) { geometry in
                    return geometry.size
                } action: { newValue in
                    size = newValue
                }
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
