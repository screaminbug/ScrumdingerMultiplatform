import SwiftUI
import KMPNativeCoroutinesAsync
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
	var body: some View {
        ScrumsView(scrums: viewModel.dailyScrums)
            .onAppear { self.viewModel.startObserving() }
	}
}

extension ContentView {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var dailyScrums: Array<DailyScrum> = []
        let dailyScrumsSource: DailyScrums = DailyScrums()
        
        func startObserving() {
            Task {
                do {
                    let sequence = asyncSequence(for: dailyScrumsSource.getFlow())
                    for try await scrum in sequence {
                        self.dailyScrums.append(scrum)
                    }
                } catch {
                    print("Failed with error:  \(error)")
                }
            }
        }
        
        deinit {
            dailyScrumsSource.closeResources() // Call the method to close HTTP client resources
        }
    }
}

struct ScrumsView: View {
    let scrums: [DailyScrum]
    var body: some View {
        NavigationStack() {
            List(scrums, id: \.id) { scrum in
                NavigationLink(destination: DetailView(scrum: scrum)) {
                    CardView(scrum: scrum)
                }
                .listRowBackground(scrum.theme.mainColor())
            }
            .navigationTitle("Daily Scrums")
            .toolbar {
                Button(action: {}) {
                    Image(systemName: "plus")
                }
                .accessibilityLabel("New Scrum")
            }
        }
    }
}
